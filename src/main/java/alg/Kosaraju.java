package alg;


import pojo.GraphList;
import util.GraphTool;
import util.PrintLog;
import util.SelfMathTool;

import java.util.ArrayList;

//求有向图的强连通分量
public class Kosaraju {

    public DfsKosaraju search(GraphList graphList){

        //dfs
        Dfs dfs = new Dfs();
        dfs.search(graphList);
        PrintLog.log(dfs.pionList);
        PrintLog.log("dfs G-T");
        ArrayList<Integer> leaveTimeList = dfs.leaveTime;
        PrintLog.log(leaveTimeList);
        Integer[][] graphMatrix = GraphTool.listToMatrix(graphList);
        PrintLog.printMatrix(graphMatrix);
        graphMatrix = SelfMathTool.transposit(graphMatrix);
        PrintLog.printMatrix(graphMatrix);
        GraphList graphListT = GraphTool.matrixToList(graphMatrix);
        DfsKosaraju dfsKosaraju = new DfsKosaraju(leaveTimeList);
        dfsKosaraju.search(graphListT);
        return dfsKosaraju;
    }
}
