package alg;


import pojo.GraphList;
import util.GraphTool;
import util.PrintLog;
import util.SelfMathTool;

import java.util.ArrayList;
import java.util.Map;

//求有向图的强连通子图
public class Kosaraju {

    public void search(GraphList graphList){

        //dfs
        Dfs dfs = new Dfs();
        dfs.search(graphList);
        PrintLog.log(dfs.pionList);


        //

        PrintLog.log("对图G的转置进行DFS搜索");
        ArrayList<Integer> leaveTimeList = dfs.leaveTime;
        PrintLog.log(leaveTimeList);

        Integer[][] graphMatrix = GraphTool.listToMatrix(graphList);

        PrintLog.printMatrix(graphMatrix);

//
//
        graphMatrix = SelfMathTool.transposit(graphMatrix);
        PrintLog.log("         ");
        PrintLog.log("         ");
        PrintLog.log("         ");
        PrintLog.log("         ");
        PrintLog.printMatrix(graphMatrix);
//
//
        GraphList graphListT = GraphTool.matrixToList(graphMatrix);


        DfsKosaraju dfsKosaraju = new DfsKosaraju(leaveTimeList);
        dfsKosaraju.search(graphListT);
    }
}
