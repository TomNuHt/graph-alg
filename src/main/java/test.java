import alg.*;
import pojo.GraphList;
import pojo.GraphMatrix;
import util.GraphTool;
import util.PrintLog;

import java.util.ArrayList;
import java.util.Map;

public class test {

    public static void main(String[] args) throws Exception {

        //buildgraph
        ArrayList<Integer> list0 = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        ArrayList<Integer> list5 = new ArrayList<Integer>();
        ArrayList<Integer> list6 = new ArrayList<Integer>();
        ArrayList<Integer> list7 = new ArrayList<Integer>();

        //g1
//        list0.add(1);
//        list1.add(0);
//        list1.add(2);
//        list2.add(1);
//        list2.add(3);
//
//        list3.add(2);
//        list3.add(4);
//        list3.add(5);
//
//        list4.add(3);
//        list4.add(5);
//        list4.add(6);
//
//        list5.add(3);
//        list5.add(4);
//        list5.add(6);
//        list5.add(7);
//
//        list6.add(4);
//        list6.add(5);
//        list6.add(7);
//
//        list7.add(5);
//        list7.add(6);

        //g2
//        list1.add(0);
//        list1.add(2);
//
//        list2.add(4);
//
//        list3.add(0);
//        list3.add(2);
//
//        list4.add(5);
//        list6.add(5);
//        list7.add(5);
//
//
//        GraphList graphList = new GraphList();
//        graphList.buildListMap(0,list0);
//        graphList.buildListMap(1,list1);
//        graphList.buildListMap(2,list2);
//        graphList.buildListMap(3,list3);
//        graphList.buildListMap(4,list4);
//        graphList.buildListMap(5,list5);
//        graphList.buildListMap(6,list6);
//        graphList.buildListMap(7,list7);

//        Bfs bfs = new Bfs();
//        bfs.search(graphList);
//        Dfs dfs = new Dfs();
//        dfs.search(graphList);
//        TopologicalSorting topologicalSorting = new TopologicalSorting();
//        topologicalSorting.search(graphList);
//        Kosaraju kosaraju = new Kosaraju();
//        kosaraju.search(graphList);

//        GraphMatrix graphMatrix = new GraphMatrix(8,8);
//        graphMatrix.addConnected("1");
//        graphMatrix.addConnected("2 4 5");
//        graphMatrix.addConnected("3 6");
//        graphMatrix.addConnected("2 7");
//        graphMatrix.addConnected("0 5");
//        graphMatrix.addConnected("6");
//        graphMatrix.addConnected("5 7");
//        graphMatrix.addConnected("7");
//        Integer[][] array = graphMatrix.returnMatrix();
//        PrintLog.printMatrix(array);
//        GraphList graphList = GraphTool.matrixToList(array);
//        Kosaraju kosaraju = new Kosaraju();
//        kosaraju.search(graphList);

//        GraphMatrix graphMatrix = new GraphMatrix(12,12);
//        graphMatrix.addConnected("1 8 11");
//        graphMatrix.addConnected("0 2 4");
//        graphMatrix.addConnected("1 3 4");
//        graphMatrix.addConnected("2 4");
//        graphMatrix.addConnected("1 2 3 5");
//        graphMatrix.addConnected("4 6 7 ");
//        graphMatrix.addConnected("5 7");
//        graphMatrix.addConnected("5 6");
//        graphMatrix.addConnected("0 11 9 10");
//        graphMatrix.addConnected("8 10");
//        graphMatrix.addConnected("8 9");
//        graphMatrix.addConnected("0 8");

        GraphMatrix graphMatrix = new GraphMatrix(12,12);
        graphMatrix.addConnected("1");
        graphMatrix.addConnected("2 9");
        graphMatrix.addConnected("1 3");
        graphMatrix.addConnected("4 8");
        graphMatrix.addConnected("3 5 10");
        graphMatrix.addConnected("4 6 7");
        graphMatrix.addConnected("5 7");
        graphMatrix.addConnected("5 6 8 9");
        graphMatrix.addConnected("3 7");
        graphMatrix.addConnected("1 7");
        graphMatrix.addConnected("4 11");
        graphMatrix.addConnected("10");

        Integer[][] array = graphMatrix.returnMatrix();
        GraphList graphList = GraphTool.matrixToList(array);

        BccEdge bccEdge = new BccEdge();
        bccEdge.search(graphList);
        ArrayList<Map> bccGroups = bccEdge.getBccGroups();

        PrintLog.printArray(bccEdge.low);
        PrintLog.printArray(bccEdge.dfn);
        PrintLog.log(bccEdge.cutEdges);
        System.out.println(bccGroups);

        for (int i = 0 ; i < bccEdge.cutEdges.size();i++){

            Integer[] a = bccEdge.cutEdges.get(i);
            System.out.println(a[0] + "-" + a[1]);

        }

//        Dfs dfs = new Dfs();
//        dfs.search(graphList);
//        PrintLog.log(dfs.leaveTime);
//        PrintLog.log(dfs.visitTime);

//        BccPoint bccPoint = new BccPoint();
//        bccPoint.search(graphList);
//        PrintLog.printArray(bccPoint.dfn);
//        PrintLog.printArray(bccPoint.low);
//        PrintLog.log(bccPoint.isCutPoint);
//        PrintLog.log(bccPoint.pionList);

    }

}
