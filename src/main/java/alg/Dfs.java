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

    public void search(GraphList graphList){

        this.graphList = graphList;
        int pointSize = this.graphList.returnList().size();
        initialGraph(pointSize);
        for (int i = 0 ; i < pointSize;i++){

            if (colorList.get(i).equals(AlgColor.ALG_COLOR_WHITE)){
                PrintLog.log("第" + i + "个点为白色，开始搜索");
                dfsCore(i);
            }

        }

        PrintLog.log("深度优先搜索树：" + pionList);
    }

    public void dfsCore(int i){


        time = time + 1;
        visitTime.set(i,time);
        PrintLog.log("第" + time + "时刻访问第：" + i + "个点");
        colorList.set(i,AlgColor.ALG_COLOR_GRAY);
        PrintLog.log("将第" + i + "个点的颜色设置为灰色");

        //链表
        ArrayList<Map> mapArrayList = this.graphList.returnList();

        //节点的链表
        Map<String,Object> map = mapArrayList.get(i);

        //与i相连的节点
        ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");
        PrintLog.log("与" + i + "相连的有：" +connectedList);

        for (int j = 0 ; j < connectedList.size();j++){

            int indexJ = connectedList.get(j);

            if (colorList.get(indexJ).equals(AlgColor.ALG_COLOR_WHITE)){

                pionList.set(indexJ,String.valueOf(i));
                dfsCore(indexJ);
                PrintLog.log("开始搜索第" + indexJ + "个点");

            }

            else {

//                PrintLog.log(indexJ + " 颜色为 " + colorList.get(indexJ));

            }
        }

        colorList.set(i,AlgColor.ALG_COLOR_BLACK);
        PrintLog.log("将第" + i + "个点设置为黑色");
//        time = time + 1;
        PrintLog.log("第" + i + "个点的离开时间为：" + time);
        leaveTime.set(i,time);

    }


    //初始化
    public void initialGraph(int pointSize){



        for (int i = 0; i < pointSize; i++){

            colorList.add(AlgColor.ALG_COLOR_WHITE);
            disList.add(Double.POSITIVE_INFINITY);
            pionList.add("nil");
            visitTime.add(0);
            leaveTime.add(0);

        }

    }

}
