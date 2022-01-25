package alg;

import interfaces.AlgColor;
import interfaces.AlgNumber;
import pojo.GraphList;
import util.GraphTool;
import util.PrintLog;
import java.util.ArrayList;
import java.util.Map;

public class BccEdge extends Dfs{

    public Integer[] dfn;
    public Integer[] low;
    public ArrayList<Integer[]> cutEdges = new ArrayList<Integer[]>();
    public ArrayList<Map> getBccGroups(){

        Integer[][] matrix = GraphTool.listToMatrix(graphList);
        for (int i = 0 ; i < cutEdges.size();i++){
            Integer[] cutEdge = cutEdges.get(i);
            PrintLog.printArray(cutEdge);
            matrix[cutEdge[0]][cutEdge[1]] = AlgNumber.ALG_INTEGER_INFINITE;
            matrix[cutEdge[1]][cutEdge[0]] = AlgNumber.ALG_INTEGER_INFINITE;
        }

        PrintLog.printMatrix(matrix);
        GraphList graphList = GraphTool.matrixToList(matrix);
        return graphList.returnList();

    }

    @Override
    public void dfsCore(int i){
        time = time + 1;
        dfn[i] = time;
        low[i] = time;
        PrintLog.log("将第" + i + "个点的dfn值设置为：" + dfn[i]);
        PrintLog.log("将第" + i + "个点的low值设置为：" + low[i]);
        visitTime.set(i,time);
        colorList.set(i, AlgColor.ALG_COLOR_GRAY);
        PrintLog.log("将第" + i + "个点的颜色设置为灰色");

        //链表
        ArrayList<Map> mapArrayList = this.graphList.returnList();

        //节点的链表
        Map<String,Object> map = mapArrayList.get(i);

        //与i相连的节点
        ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");

        PrintLog.log("与" + i + "相连的点有：" + connectedList);
        for (int j = 0 ; j < connectedList.size();j++){

            int indexJ = connectedList.get(j);
            if (colorList.get(indexJ).equals(AlgColor.ALG_COLOR_WHITE)){//indexJ未被访问过
                pionList.set(indexJ,String.valueOf(i));
                dfsCore(indexJ);
                low[i] = Math.min(low[i],low[indexJ]);
                if(low[indexJ] > dfn[i]){
                    Integer[] cutEdge = new Integer[2];
                    cutEdge[0] = i;
                    cutEdge[1] = indexJ;
                    PrintLog.log("add: " + i + "-" + indexJ);
                    cutEdges.add(cutEdge);

                }

            }

            else {

                PrintLog.log("第" + indexJ + "个点已被访问过");
                PrintLog.log(pionList);
                PrintLog.log(i);
                if (pionList.get(i).equals("nil")) {
                    low[i] = Math.min(low[i],dfn[indexJ]);
                }
                else if (Integer.valueOf(pionList.get(i)) != indexJ){
                    low[i] = Math.min(low[i],dfn[indexJ]);
                }

            }

        }
        colorList.set(i,AlgColor.ALG_COLOR_BLACK);
        PrintLog.log("将第" + i + "个点设置为黑色");
        PrintLog.log("第" + i + "个点的离开时间为：" + time);
        leaveTime.set(i,time);

    }


    //初始化
    @Override
    public void initialGraph(int pointSize){

        dfn = new Integer[pointSize];
        low = new Integer[pointSize];
        for (int i = 0; i < pointSize; i++){
            colorList.add(AlgColor.ALG_COLOR_WHITE);
            disList.add(Double.POSITIVE_INFINITY);
            pionList.add("nil");
            visitTime.add(0);
            leaveTime.add(0);
            dfn[i] = 0;
            low[i] = 0;
        }
    }
}

