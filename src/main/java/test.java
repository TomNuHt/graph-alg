import alg.*;
import pojo.GraphList;
import pojo.GraphMatrix;
import pojo.GraphMatrixWeight;
import util.PrintLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) throws Exception {

        //buildgraph
//        ArrayList<Integer> list0 = new ArrayList<Integer>();
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        ArrayList<Integer> list3 = new ArrayList<Integer>();
//        ArrayList<Integer> list4 = new ArrayList<Integer>();
//        ArrayList<Integer> list5 = new ArrayList<Integer>();
//        ArrayList<Integer> list6 = new ArrayList<Integer>();
//        ArrayList<Integer> list7 = new ArrayList<Integer>();

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

//        GraphMatrix graphMatrix = new GraphMatrix(12,12);
//        graphMatrix.addConnected("1");
//        graphMatrix.addConnected("2 9");
//        graphMatrix.addConnected("1 3");
//        graphMatrix.addConnected("4 8");
//        graphMatrix.addConnected("3 5 10");
//        graphMatrix.addConnected("4 6 7");
//        graphMatrix.addConnected("5 7");
//        graphMatrix.addConnected("5 6 8 9");
//        graphMatrix.addConnected("3 7");
//        graphMatrix.addConnected("1 7");
//        graphMatrix.addConnected("4 11");
//        graphMatrix.addConnected("10");
//
//        Integer[][] array = graphMatrix.returnMatrix();
//        GraphList graphList = GraphTool.matrixToList(array);
//
//        BccEdge bccEdge = new BccEdge();
//        bccEdge.search(graphList);
//        ArrayList<Map> bccGroups = bccEdge.getBccGroups();
//
//        PrintLog.printArray(bccEdge.low);
//        PrintLog.printArray(bccEdge.dfn);
//        PrintLog.log(bccEdge.cutEdges);
//        System.out.println(bccGroups);
//
//        for (int i = 0 ; i < bccEdge.cutEdges.size();i++){
//
//            Integer[] a = bccEdge.cutEdges.get(i);
//            System.out.println(a[0] + "-" + a[1]);
//
//        }

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

//        GraphMatrixWeight graphMatrix = new GraphMatrixWeight(9,9);
//        graphMatrix.addConnected("1 7");
//        graphMatrix.addConnected("0 2 7");
//        graphMatrix.addConnected("1 3 8 5");
//        graphMatrix.addConnected("2 4 5");
//        graphMatrix.addConnected("3 5");
//        graphMatrix.addConnected("6 3 2");
//        graphMatrix.addConnected("5 7");
//        graphMatrix.addConnected("6 8 1 0");
//        graphMatrix.addConnected("2 7");
//
//        Map<String,Double> edgeMap = new HashMap<String, Double>();
//        edgeMap.put("0_1",4.0);
//        edgeMap.put("0_7",8.0);
//        edgeMap.put("1_7",11.0);
//        edgeMap.put("1_2",8.0);
//        edgeMap.put("2_8",2.0);
//        edgeMap.put("7_8",7.0);
//        edgeMap.put("6_7",1.0);
//        edgeMap.put("5_6",2.0);
//        edgeMap.put("2_5",4.0);
//        edgeMap.put("2_3",7.0);
//        edgeMap.put("3_5",14.0);
//        edgeMap.put("3_4",9.0);
//        edgeMap.put("4_5",10.0);
//        Double[][] graphArray = graphMatrix.importEdgeMap(edgeMap);
//        PrintLog.printMatrix(graphArray);
//        Kruskal kruskal = new Kruskal();
//        kruskal.search(graphArray);
//        Prim prim = new Prim();
//        prim.search(graphArray);

//        ArrayList<Integer> list0 = new ArrayList<Integer>();
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        ArrayList<Integer> list3 = new ArrayList<Integer>();
//        ArrayList<Integer> list4 = new ArrayList<Integer>();
//        list0.add(1);
//        list0.add(4);
//        list1.add(2);
//        list1.add(4);
//        list1.add(3);
//        list2.add(1);
//        list3.add(2);
//        list3.add(0);
//        list4.add(2);
//        list4.add(3);
//        GraphList graphList = new GraphList();
//        graphList.buildListMap(0,list0);
//        graphList.buildListMap(1,list1);
//        graphList.buildListMap(2,list2);
//        graphList.buildListMap(3,list3);
//        graphList.buildListMap(4,list4);
//
//        Map<String,Double> edgeMap = new HashMap<String, Double>();
//        edgeMap.put("0_1",6.0);
//        edgeMap.put("0_4",7.0);
//        edgeMap.put("1_2",5.0);
//        edgeMap.put("1_4",8.0);
//        edgeMap.put("1_3",-4.0);
//        edgeMap.put("2_1",-2.0);
//        edgeMap.put("3_2",7.0);
//        edgeMap.put("3_0",2.0);
//        edgeMap.put("4_2",-3.0);
//        edgeMap.put("4_3",9.0);

//        BellmanFord bellmanFord = new BellmanFord();
//        boolean hasNegCircle = bellmanFord.cal(graphList,edgeMap,0);
//        PrintLog.log(hasNegCircle);
//        ArrayList<Double> sd = bellmanFord.sd;
//        PrintLog.log(sd);


//        ArrayList<Integer> list0 = new ArrayList<Integer>();
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        ArrayList<Integer> list3 = new ArrayList<Integer>();
//        ArrayList<Integer> list4 = new ArrayList<Integer>();
//        ArrayList<Integer> list5 = new ArrayList<Integer>();
//
//        list1.add(0);
//        list2.add(1);
//        list2.add(0);
//        list3.add(2);
//        list3.add(1);
//        list3.add(0);
//        list4.add(2);
//        list4.add(3);
//        list5.add(4);
//        list5.add(3);
//
//        GraphList graphList = new GraphList();
//        graphList.buildListMap(0,list0);
//        graphList.buildListMap(1,list1);
//        graphList.buildListMap(2,list2);
//        graphList.buildListMap(3,list3);
//        graphList.buildListMap(4,list4);
//        graphList.buildListMap(5,list5);
//
//        Map<String,Double> edgeMap = new HashMap<String, Double>();
//        edgeMap.put("5_4",5.0);
//        edgeMap.put("5_3",3.0);
//        edgeMap.put("4_2",6.0);
//        edgeMap.put("4_3",2.0);
//        edgeMap.put("3_2",7.0);
//        edgeMap.put("3_1",4.0);
//        edgeMap.put("3_0",2.0);
//        edgeMap.put("2_1",-1.0);
//        edgeMap.put("2_0",1.0);
//        edgeMap.put("1_0",-2.0);



        ArrayList<Integer> list0 = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();

        list0.add(1);
        list0.add(4);
        list1.add(4);
        list1.add(2);
        list2.add(3);
        list3.add(2);
        list3.add(0);
        list4.add(2);
        list4.add(3);
        list4.add(1);


        GraphList graphList = new GraphList();
        graphList.buildListMap(0,list0);
        graphList.buildListMap(1,list1);
        graphList.buildListMap(2,list2);
        graphList.buildListMap(3,list3);
        graphList.buildListMap(4,list4);

        Map<String,Double> edgeMap = new HashMap<String, Double>();

        edgeMap.put("4_1",3.0);
        edgeMap.put("4_2",9.0);
        edgeMap.put("4_3",2.0);
        edgeMap.put("3_2",6.0);
        edgeMap.put("3_0",7.0);
        edgeMap.put("2_3",4.0);
        edgeMap.put("1_2",1.0);
        edgeMap.put("1_4",2.0);
        edgeMap.put("0_4",5.0);
        edgeMap.put("0_1",10.0);

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.cal(graphList,edgeMap,0);
        ArrayList<Double> sd = dijkstra.sd;
        PrintLog.log(sd);
    }

}
