import alg.*;
import com.google.gson.Gson;
import pojo.GraphList;
import pojo.GraphMatrix;
import pojo.GraphMatrixWeight;
import util.GraphTool;
import util.PrintLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) throws Exception {
        //--------------------------------------------------------------
        //dfs算法测试用例算法导论351
//        ArrayList<Integer> list0 = new ArrayList<Integer>();
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        ArrayList<Integer> list3 = new ArrayList<Integer>();
//        ArrayList<Integer> list4 = new ArrayList<Integer>();
//        ArrayList<Integer> list5 = new ArrayList<Integer>();
//        list0.add(2);
//        list1.add(0);
//        list1.add(2);
//        list2.add(3);
//        list3.add(0);
//        list4.add(3);
//        list4.add(5);
//        list5.add(5);
//        GraphList graphList = new GraphList();
//        graphList.buildListMap(0,list0);
//        graphList.buildListMap(1,list1);
//        graphList.buildListMap(2,list2);
//        graphList.buildListMap(3,list3);
//        graphList.buildListMap(4,list4);
//        graphList.buildListMap(5,list5);
//        Dfs dfs = new Dfs();
//        dfs.search(graphList);
//        dfs.searchBy(graphList,5);

        //--------------------------------------------------------------
        //bfs算法测试用例，算法导论345页
//        ArrayList<Integer> list0 = new ArrayList<Integer>();
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        ArrayList<Integer> list3 = new ArrayList<Integer>();
//        ArrayList<Integer> list4 = new ArrayList<Integer>();
//        ArrayList<Integer> list5 = new ArrayList<Integer>();
//        ArrayList<Integer> list6 = new ArrayList<Integer>();
//        ArrayList<Integer> list7 = new ArrayList<Integer>();
//        list0.add(1);
//        list1.add(0);
//        list1.add(2);
//        list2.add(1);
//        list2.add(3);
//        list3.add(2);
//        list3.add(4);
//        list3.add(5);
//        list4.add(3);
//        list4.add(5);
//        list4.add(6);
//        list5.add(3);
//        list5.add(4);
//        list5.add(6);
//        list6.add(4);
//        list6.add(5);
//        list6.add(7);
//        list7.add(5);
//        list7.add(6);
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
//        bfs.searchBy(graphList,2);

        //--------------------------------------------------------------
        //TopologicalSorting算法测试用例，算法导论355页
//        ArrayList<Integer> list0 = new ArrayList<Integer>();
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        ArrayList<Integer> list3 = new ArrayList<Integer>();
//        ArrayList<Integer> list4 = new ArrayList<Integer>();
//        ArrayList<Integer> list5 = new ArrayList<Integer>();
//        ArrayList<Integer> list6 = new ArrayList<Integer>();
//        ArrayList<Integer> list7 = new ArrayList<Integer>();
//        ArrayList<Integer> list8 = new ArrayList<Integer>();
//        list0.add(1);
//        list0.add(7);
//        list1.add(2);
//        list1.add(7);
//        list2.add(5);
//        list3.add(4);
//        list3.add(2);
//        list4.add(5);
//        list6.add(7);
//        GraphList graphList = new GraphList();
//        graphList.buildListMap(0,list0);
//        graphList.buildListMap(1,list1);
//        graphList.buildListMap(2,list2);
//        graphList.buildListMap(3,list3);
//        graphList.buildListMap(4,list4);
//        graphList.buildListMap(5,list5);
//        graphList.buildListMap(6,list6);
//        graphList.buildListMap(7,list7);
//        graphList.buildListMap(8,list8);
//        TopologicalSorting topologicalSorting = new TopologicalSorting();
//        topologicalSorting.search(graphList);
        //--------------------------------------------------------------
        //Kosaraju算法测试用例，算法导论357页
//        ArrayList<Integer> list0 = new ArrayList<Integer>();
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        ArrayList<Integer> list3 = new ArrayList<Integer>();
//        ArrayList<Integer> list4 = new ArrayList<Integer>();
//        ArrayList<Integer> list5 = new ArrayList<Integer>();
//        ArrayList<Integer> list6 = new ArrayList<Integer>();
//        ArrayList<Integer> list7 = new ArrayList<Integer>();
//        list0.add(1);
//        list1.add(2);
//        list1.add(4);
//        list1.add(5);
//        list2.add(3);
//        list2.add(6);
//        list3.add(7);
//        list3.add(2);
//        list4.add(0);
//        list4.add(5);
//        list5.add(6);
//        list6.add(5);
//        list6.add(7);
//        list7.add(7);
//        GraphList graphList = new GraphList();
//        graphList.buildListMap(0,list0);
//        graphList.buildListMap(1,list1);
//        graphList.buildListMap(2,list2);
//        graphList.buildListMap(3,list3);
//        graphList.buildListMap(4,list4);
//        graphList.buildListMap(5,list5);
//        graphList.buildListMap(6,list6);
//        graphList.buildListMap(7,list7);
//        Kosaraju kosaraju = new Kosaraju();
//        kosaraju.search(graphList);
        //--------------------------------------------------------------
        //Bccedge、BccPoint算法测试用例算法导论360页22-2
        GraphMatrix graphMatrix = new GraphMatrix(23,23);
        graphMatrix.addConnectedCore(0,"1 2 3");
        graphMatrix.addConnectedCore(1,"0 2 3");
        graphMatrix.addConnectedCore(2,"1 0 3 4");
        graphMatrix.addConnectedCore(3,"0 1 2");
        graphMatrix.addConnectedCore(4,"5 6 7 8 2 10");
        graphMatrix.addConnectedCore(5,"4 6");
        graphMatrix.addConnectedCore(6,"4 5");
        graphMatrix.addConnectedCore(7,"4 8");
        graphMatrix.addConnectedCore(8,"4 7 9");
        graphMatrix.addConnectedCore(9,"8");
        graphMatrix.addConnectedCore(10,"4 11 13");
        graphMatrix.addConnectedCore(11,"10 12");
        graphMatrix.addConnectedCore(12,"11 13 14");
        graphMatrix.addConnectedCore(13,"10 12");
        graphMatrix.addConnectedCore(14,"12 15 16 18");
        graphMatrix.addConnectedCore(15,"14 18 16 17");
        graphMatrix.addConnectedCore(16,"15 18 17 14");
        graphMatrix.addConnectedCore(17,"15 16 18");
        graphMatrix.addConnectedCore(18,"14 15 16 17 19 22");
        graphMatrix.addConnectedCore(19,"20 18 21");
        graphMatrix.addConnectedCore(20,"21 19");
        graphMatrix.addConnectedCore(21,"20 19");
        graphMatrix.addConnectedCore(22,"18");
        Integer[][] array = graphMatrix.returnMatrix();
        GraphList graphList = GraphTool.matrixToList(array);

//        BccEdge bccEdge = new BccEdge();
//        bccEdge.search(graphList);
//        ArrayList<ArrayList<String>> groups = bccEdge.getBccGroups();
//        PrintLog.log(groups);

        BccPoint bccPoint = new BccPoint();
        bccPoint.search(graphList);
        PrintLog.log(bccPoint.isCutPoint);
        PrintLog.log(bccPoint.cutPointList);
        ArrayList<Map> bccGroups = bccPoint.bccGroups;
        Gson gson = new Gson();
        String str = gson.toJson(bccGroups);
        PrintLog.log(str);

        //--------------------------------------------------------------
        //Kruskal算法测试用例算法导论360页22-2
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



//        ArrayList<Integer> list0 = new ArrayList<Integer>();
//        ArrayList<Integer> list1 = new ArrayList<Integer>();
//        ArrayList<Integer> list2 = new ArrayList<Integer>();
//        ArrayList<Integer> list3 = new ArrayList<Integer>();
//        ArrayList<Integer> list4 = new ArrayList<Integer>();
//
//        list0.add(1);
//        list0.add(4);
//        list1.add(4);
//        list1.add(2);
//        list2.add(3);
//        list3.add(2);
//        list3.add(0);
//        list4.add(2);
//        list4.add(3);
//        list4.add(1);


//        GraphList graphList = new GraphList();
//        graphList.buildListMap(0,list0);
//        graphList.buildListMap(1,list1);
//        graphList.buildListMap(2,list2);
//        graphList.buildListMap(3,list3);
//        graphList.buildListMap(4,list4);
//
//        Map<String,Double> edgeMap = new HashMap<String, Double>();
//
//        edgeMap.put("4_1",3.0);
//        edgeMap.put("4_2",9.0);
//        edgeMap.put("4_3",2.0);
//        edgeMap.put("3_2",6.0);
//        edgeMap.put("3_0",7.0);
//        edgeMap.put("2_3",4.0);
//        edgeMap.put("1_2",1.0);
//        edgeMap.put("1_4",2.0);
//        edgeMap.put("0_4",5.0);
//        edgeMap.put("0_1",10.0);
//
//        Dijkstra dijkstra = new Dijkstra();
//        dijkstra.cal(graphList,edgeMap,0);
//        ArrayList<Double> sd = dijkstra.sd;
//        PrintLog.log(sd);


//        GraphMatrixWeight graphMatrix = new GraphMatrixWeight(5,5);
//        graphMatrix.addConnected("1 2 4");
//        graphMatrix.addConnected("3 4");
//        graphMatrix.addConnected("1");
//        graphMatrix.addConnected("0 2");
//        graphMatrix.addConnected("3");
//        Map<String,Double> edgeMap = new HashMap();
//        edgeMap.put("0_1",3.0);
//        edgeMap.put("0_2",8.0);
//        edgeMap.put("0_4",-4.0);
//        edgeMap.put("1_3",1.0);
//        edgeMap.put("1_4",7.0);
//        edgeMap.put("2_1",4.0);
//        edgeMap.put("3_0",2.0);
//        edgeMap.put("3_2",-5.0);
//        edgeMap.put("4_3",6.0);
//        Double[][] graphArray = graphMatrix.importEdgeMap(edgeMap);
//        FloydWarShall floydWarShall = new FloydWarShall();
//        floydWarShall.cal(graphArray);


//        GraphMatrixWeight graphMatrixWeight = new GraphMatrixWeight(6,6);
//        graphMatrixWeight.addConnectedCore(0,"1 2");
//        graphMatrixWeight.addConnectedCore(1,"3");
//        graphMatrixWeight.addConnectedCore(2,"1 4");
//        graphMatrixWeight.addConnectedCore(3,"2 5");
//        graphMatrixWeight.addConnectedCore(4,"3 5");
//        Map<String,Double> edgeCapacityMap = new HashMap<String, Double>();
//        edgeCapacityMap.put("0_1",16.0);
//        edgeCapacityMap.put("0_2",13.0);
//        edgeCapacityMap.put("1_3",12.0);
//        edgeCapacityMap.put("2_1",4.0);
//        edgeCapacityMap.put("2_4",14.0);
//        edgeCapacityMap.put("3_2",9.0);
//        edgeCapacityMap.put("3_5",20.0);
//        edgeCapacityMap.put("4_3",7.0);
//        edgeCapacityMap.put("4_5",4.0);
//
//        Map<String,Double> edgeMap = new HashMap<String, Double>();
//        edgeMap.put("0_1",0.0);
//        edgeMap.put("0_2",0.0);
//        edgeMap.put("1_3",0.0);
//        edgeMap.put("2_1",0.0);
//        edgeMap.put("2_4",0.0);
//        edgeMap.put("3_2",0.0);
//        edgeMap.put("3_5",0.0);
//        edgeMap.put("4_3",0.0);
//        edgeMap.put("4_5",0.0);
//
//        Double[][] graphArray = graphMatrixWeight.importEdgeMap(edgeMap);
//        FordFulkson fordFulkson = new FordFulkson();
//        fordFulkson.cal(graphArray,edgeCapacityMap,0,5);

    }

}
