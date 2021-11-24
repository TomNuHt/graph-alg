package alg;

import pojo.GraphList;
import util.PrintLog;

import java.util.ArrayList;
import java.util.Map;

public class TopologicalSorting {

    public ArrayList<Integer> inDegreeList = new ArrayList<Integer>();
    public ArrayList<Integer> outDegreeList = new ArrayList<Integer>();
    public ArrayList<Integer> queue = new ArrayList<Integer>();
    public GraphList graphList;

    public void search(GraphList graphList) throws Exception {


        this.graphList = graphList;
        //根据链表计算各个顶点的入度和出度
        ArrayList<Map> mapArrayList = graphList.returnList();

        //
        int vertexSize = mapArrayList.size();
        initial(vertexSize);

        //计算每个顶点的出度和入度
        for (int i = 0 ; i < mapArrayList.size();i++){

            Map map = mapArrayList.get(i);
            int vertexIndex = (Integer) map.get("index");
            ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");
            outDegreeList.set(vertexIndex,connectedList.size());
            for (int j = 0 ; j < connectedList.size();j++){
                int connVertexIndex = connectedList.get(j);
                inDegreeList.set(connVertexIndex,inDegreeList.get(connVertexIndex) + 1);
            }
        }

        PrintLog.log("初始入度:" + inDegreeList);
        PrintLog.log("初始出度:" + outDegreeList);

        if (!inDegreeList.contains(0)){

            throw new Exception("该图存在环");

        }

        int theFirstPickPoint = -1;

        //找到一个入度为0的顶点
        for (int i = 0 ; i < vertexSize;i++){

            if (inDegreeList.get(i).equals(0)){

                theFirstPickPoint = i;
                break;

            }

        }

        PrintLog.log("算法挑选的入度为0的初始点：" + theFirstPickPoint);
        
        tsCore(theFirstPickPoint);

        PrintLog.log(queue);
    }

    public void tsCore(int vertexIndex) throws Exception {

        queue.add(vertexIndex);
        PrintLog.log("队列加入：" + vertexIndex + " ,队列为：" + queue);

        inDegreeList.set(vertexIndex,-11111);
        PrintLog.log("入度队列清除 ：" + vertexIndex + ",入度队列为：" + inDegreeList);

        ArrayList<Map> mapArrayList = this.graphList.returnList();
        Map map = mapArrayList.get(vertexIndex);
        ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");

        for (int i = 0; i < connectedList.size();i++){

            int index = connectedList.get(i);
            inDegreeList.set(index,inDegreeList.get(index) - 1);
        }
        int nextIndex = -1;

        for (int i = 0; i < inDegreeList.size();i++){
            if (inDegreeList.get(i).equals(0)){
                nextIndex = i;
                break;
            }
        }

        for (int i = 0 ; i < inDegreeList.size();i++){

            if(inDegreeList.get(i) != -11111 && nextIndex == -1){

                PrintLog.log(inDegreeList);
                throw new Exception("该图有环");

            }

        }

        if (nextIndex != -1){
            tsCore(nextIndex);
        }
    }


    public void initial(int vertexSize){

        for (int i = 0 ; i < vertexSize;i++){
            inDegreeList.add(0);
            outDegreeList.add(0);
        }


    }

}
