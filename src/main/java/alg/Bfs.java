package alg;

import interfaces.AlgColor;
import pojo.GraphList;
import util.PrintLog;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;


public class Bfs {

    //各个节点的颜色
    ArrayList<String> colorList = new ArrayList<String>();
    //各个节点到根节点的距离
    ArrayList<Double> disList = new ArrayList<Double>();
    //每个节点的父亲节点
    ArrayList<String> pionList = new ArrayList<String>();
    //管道
    ArrayList<Integer> queue = new ArrayList<Integer>();

    GraphList graphList;

    public void search(GraphList graphList){

        this.graphList = graphList;

        Random random = new Random();

        //初始化
        int pointSize = this.graphList.returnList().size();

        PrintLog.log(pointSize);

        initialGraph(pointSize);

        //挑选某个节点为根节点
        int firstVertex = random.nextInt(pointSize);

        PrintLog.log(firstVertex);

        //链表
        ArrayList<Map> mapArrayList = this.graphList.returnList();

        //根节点的链表
        Map<String,Object> rootMap = mapArrayList.get(firstVertex);

        int firstVertexIndex = (Integer) rootMap.get("index");

        //
        colorList.set(firstVertexIndex,AlgColor.ALG_COLOR_GRAY);
        pionList.set(firstVertexIndex,"nil");
        disList.set(firstVertexIndex,0.0);
        queue.add(firstVertexIndex);

        PrintLog.log(graphList.returnList().size());

        bfsCore();
        System.out.println(pionList);
        PrintLog.log(colorList);


        while (colorList.contains(AlgColor.ALG_COLOR_WHITE)){

            int left = colorList.indexOf(AlgColor.ALG_COLOR_WHITE);
            colorList.set(left,AlgColor.ALG_COLOR_GRAY);
            pionList.set(left,"nil");
            disList.set(left,0.0);
            this.queue = new ArrayList<Integer>();
            queue.add(left);
            bfsCore();

        }

        PrintLog.log(pionList);



    }

    public void bfsCore(){


        while (null != queue && queue.size()!= 0){

            //把队列中第一个元素踢出
            Integer firstVertexInQ = queue.get(0);
            queue.remove(firstVertexInQ);
            colorList.set(firstVertexInQ,AlgColor.ALG_COLOR_BLACK);
            //链表
            ArrayList<Map> mapArrayList = graphList.returnList();
            //根节点的链表
            Map<String,Object> map = mapArrayList.get(firstVertexInQ);
            ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");

            for (int i = 0 ; i < connectedList.size();i++){

                if (colorList.get(connectedList.get(i)).equals(AlgColor.ALG_COLOR_WHITE)){

                    queue.add(connectedList.get(i));
                    colorList.set(connectedList.get(i),AlgColor.ALG_COLOR_GRAY);
                    disList.set(connectedList.get(i),disList.get(firstVertexInQ) + 1);
                    pionList.set(connectedList.get(i),String.valueOf(firstVertexInQ));

                }

            }

            while (null != queue && queue.size()!= 0){

                bfsCore();

            }


        }


    }


    //初始化
    public void initialGraph(int pointSize){

        for (int i = 0; i < pointSize; i++){

            colorList.add(AlgColor.ALG_COLOR_WHITE);
            disList.add(Double.POSITIVE_INFINITY);
            pionList.add("-1");

        }


    }

}
