package alg;

import interfaces.AlgNumber;
import pojo.GraphList;
import util.PrintLog;

import java.util.ArrayList;
import java.util.Map;

//有向无环图的单源最短路算法
public class DagShortestPath {

    public ArrayList<Double> sd = new ArrayList<Double>();
    public ArrayList<Integer> pai = new ArrayList<Integer>();

    public void cal(GraphList graphList, Map<String, Double> edgeMap, Integer sourceIndex) throws Exception {

        ArrayList<Map> graphMapList = graphList.returnList();
        initialSingleSource(graphMapList.size(),sourceIndex);
        TopologicalSorting topologicalSorting = new TopologicalSorting();
        topologicalSorting.search(graphList);
        ArrayList<Integer> queue = topologicalSorting.queue;
//        ArrayList<Map> graphLists = graphList.returnList();
        Map<Integer,ArrayList<Integer>> graphMap = graphList.returnMap();
        for (int i = 0 ; i < queue.size();i++){

            PrintLog.log("========" +queue.get(i) + "+++++++");
            if (i < queue.indexOf(sourceIndex)){

                continue;

            }

            ArrayList<Integer> vertexIndexListConnectedTo = graphMap.get(queue.get(i));
            for (int j = 0 ; j < vertexIndexListConnectedTo.size();j++){

                int temp = vertexIndexListConnectedTo.get(j);
                PrintLog.log(queue.get(i) + "_" + temp);
                double weight = edgeMap.get(queue.get(i)+ "_" + temp);
                relax(queue.get(i),temp,weight);
            }




        }

    }

    public void relax(int u,int v,double weight){

        if (sd.get(v) > (sd.get(u) + weight)){

            sd.set(v,sd.get(u) + weight);
            pai.set(v,u);

        }
    }

    public void initialSingleSource(Integer vertexSize,Integer sourceIndex){

        for (int i = 0 ; i < vertexSize;i++){
            sd.add(AlgNumber.ALG_DOUBLE_INFINITE);
            pai.add(AlgNumber.ALG_NILL_INTEGER);
        }
        sd.set(sourceIndex,0.0);
    }

}
