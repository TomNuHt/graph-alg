package alg;

import interfaces.AlgColor;
import interfaces.AlgNumber;
import pojo.GraphList;
import util.GraphTool;
import util.PrintLog;
import java.util.ArrayList;
import java.util.Map;

//
public class BccEdge extends Dfs{

    public Integer[] dfn;
    public Integer[] low;
    public ArrayList<Integer[]> cutEdges = new ArrayList<Integer[]>();

    //remove cut edges of the graph
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
        PrintLog.log("set dfn of point:" + i + " to " + dfn[i]);
        PrintLog.log("set low of point:" + i + " to " + low[i]);
        visitTime.set(i,time);
        colorList.set(i, AlgColor.ALG_COLOR_GRAY);
        PrintLog.log("set color of point:" + i + " to gray");

        //链表
        ArrayList<Map> mapArrayList = this.graphList.returnList();

        //节点的链表
        Map<String,Object> map = mapArrayList.get(i);

        //与i相连的节点
        ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");

        PrintLog.log("adj of point:" + i + " are：" + connectedList);
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

                PrintLog.log("point:" + indexJ + " was already visited");
                if (pionList.get(i).equals("nil")) {
                    low[i] = Math.min(low[i],dfn[indexJ]);
                }
                else if (Integer.valueOf(pionList.get(i)) != indexJ){
                    low[i] = Math.min(low[i],dfn[indexJ]);
                }

            }

        }
        colorList.set(i,AlgColor.ALG_COLOR_BLACK);
        PrintLog.log("set color of point:" + i + " to black");
        PrintLog.log("point:" + i + " left at：" + time);
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

