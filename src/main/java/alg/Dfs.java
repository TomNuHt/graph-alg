package alg;

import interfaces.AlgColor;
import interfaces.AlgNumber;
import pojo.GraphList;
import util.PrintLog;

import java.util.ArrayList;
import java.util.Map;


public class Dfs {


    GraphList graphList;

    //各个节点的颜色
    public ArrayList<String> colorList = new ArrayList<String>();
    //各个节点到根节点的距离
    public ArrayList<Double> disList = new ArrayList<Double>();
    //每个节点的父亲节点
    public ArrayList<String> pionList = new ArrayList<String>();
    //每个顶点被发现的时间
    public ArrayList<Integer> visitTime = new ArrayList<Integer>();
    //每个顶点离开的时间
    public ArrayList<Integer> leaveTime = new ArrayList<Integer>();
    int time = 0;

    //begin search from 0
    public void search(GraphList graphList){

        this.graphList = graphList;
        int pointSize = this.graphList.returnList().size();
        initialGraph(pointSize);
        for (int i = 0 ; i < pointSize;i++){

            if (colorList.get(i).equals(AlgColor.ALG_COLOR_WHITE)){
                PrintLog.log("point:" + i + " is white，begin search:");
                dfsCore(i);
            }

        }

        PrintLog.log("pion list of dfs tree:" + pionList);
    }


    public void searchBy(GraphList graphList,int firstIndex){

        this.graphList = graphList;
        int pointSize = this.graphList.returnList().size();
        initialGraph(pointSize);
        PrintLog.log("point:" + firstIndex + " is white，begin search:");
        dfsCore(firstIndex);
        for (int i = 0 ; i < pointSize;i++){

            if (i == firstIndex){

                continue;
            }
            if (colorList.get(i).equals(AlgColor.ALG_COLOR_WHITE)){
                PrintLog.log("point:" + i + " is white，begin search:");
                dfsCore(i);
            }
        }
        PrintLog.log("pion list of dfs tree:" + pionList);
    }

    public void dfsCore(int i){


        time = time + 1;
        visitTime.set(i,time);
        PrintLog.log("at time:" + time + ",visit point:" + i);
        colorList.set(i,AlgColor.ALG_COLOR_GRAY);
        PrintLog.log("set color of point:" + i + " to gray");

        //链表
        ArrayList<Map> mapArrayList = this.graphList.returnList();

        //节点的链表
        Map<String,Object> map = mapArrayList.get(i);

        //与i相连的节点
        ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");
        PrintLog.log("adj of point:" + i + " is：" +connectedList);

        for (int j = 0 ; j < connectedList.size();j++){

            int indexJ = connectedList.get(j);

            if (colorList.get(indexJ).equals(AlgColor.ALG_COLOR_WHITE)){

                pionList.set(indexJ,String.valueOf(i));
                dfsCore(indexJ);
                PrintLog.log("begin to search point:" + indexJ);

            }

            else {

//                PrintLog.log(indexJ + " 颜色为 " + colorList.get(indexJ));

            }
        }

        colorList.set(i,AlgColor.ALG_COLOR_BLACK);
        PrintLog.log("set color of point:" + i + " to black");
        time = time + 1;
        PrintLog.log("the leave time of point:" + i + " is time:" + time);
        leaveTime.set(i,time);

    }


    //初始化
    public void initialGraph(int pointSize){

        for (int i = 0; i < pointSize; i++){

            colorList.add(AlgColor.ALG_COLOR_WHITE);
            disList.add(AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY);
            pionList.add("nil");
            visitTime.add(0);
            leaveTime.add(0);

        }

    }

}
