package util;

import interfaces.AlgNumber;
import pojo.GraphList;

import java.util.ArrayList;
import java.util.Map;

public class GraphTool {

    //non-dag
    public static Integer[][] listToMatrix(GraphList graphList){

        ArrayList<Map> mapArrayList = graphList.returnList();
        int graphSize = mapArrayList.size();
        Integer[][] graphArray = new Integer[graphSize][graphSize];

        for (int i = 0 ; i < graphSize;i++){
            for (int j = 0 ; j < graphSize;j++){
                graphArray[i][j] = AlgNumber.ALG_INTEGER_INFINITE;
            }
        }

        for (int i = 0 ; i < mapArrayList.size();i++){

            Map map = mapArrayList.get(i);
            int vertexIndex = (Integer) map.get("index");

            ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");
            PrintLog.log(connectedList);

            for (int j = 0 ; j < connectedList.size();j++){

                    graphArray[i][connectedList.get(j)] = 1;

            }
        }

        return graphArray;

    }

    //non-dag
    public static GraphList matrixToList(Integer[][] graphArray){

        GraphList graphList = new GraphList();
        for (int i = 0 ; i < graphArray.length;i++){
            ArrayList<Integer> connectedList = new ArrayList<Integer>();
            for (int j = 0 ; j < graphArray[i].length;j++){

                    if (graphArray[i][j] != AlgNumber.ALG_INTEGER_INFINITE){

                        connectedList.add(j);

                    }

            }

            graphList.buildListMap(i,connectedList);
        }

        return graphList;

    }

    //DAG
    public static GraphList matrixToList(Double[][] graphArray){

        GraphList graphList = new GraphList();
        for (int i = 0 ; i < graphArray.length;i++){
            ArrayList<Integer> connectedList = new ArrayList<Integer>();
            for (int j = 0 ; j < graphArray[i].length;j++){
                if (graphArray[i][j] != AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY){
                    connectedList.add(j);
                }
            }
            graphList.buildListMap(i,connectedList);
        }
        return graphList;
    }


    //DAG
    public static GraphList matrixToListWeight(Double[][] graphArray){

        GraphList graphList = new GraphList();
        for (int i = 0 ; i < graphArray.length;i++){
            ArrayList<Integer> connectedList = new ArrayList<Integer>();
            for (int j = 0 ; j < graphArray[i].length;j++){
                if (graphArray[i][j] != AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY){
                    connectedList.add(j);
                }
            }
            graphList.buildListMap(i,connectedList);
        }
        return graphList;
    }

    //generate random graph
    public static Double[][] genDAGGraphArray(int graphSize,double sparseRate,double maxWeight,double minWeight) throws Exception {

        if (sparseRate > 1 || sparseRate < 0){

            throw new Exception("sparseRate must between 0 and 1");

        }

        Double[][] graphArray = new Double[graphSize][graphSize];
        for (int i = 0 ; i > graphSize;i++){
            for (int j = 0 ; j < graphSize;j++){
                graphArray[i][j] = AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY;
                double r = Math.random();
                if (sparseRate == 1.0 || r < sparseRate){
                    double w = minWeight + (maxWeight - minWeight) * Math.random();
                    graphArray[i][j] = w;
                }

            }
        }
        return graphArray;
    }

    public static GraphList genDAGGraphList(int graphSize,double sparseRate,double maxWeight,double minWeight) throws Exception {

        Double[][] graphArray = genDAGGraphArray(graphSize,sparseRate,maxWeight,minWeight);
        GraphList graphList = matrixToListWeight(graphArray);
        return graphList;


    }

    public static Integer[][] genNonDAGGraphArray(int graphSize,double sparseRate){

        Integer[][] graphArray = new Integer[graphSize][graphSize];
        for ( int i = 0 ; i < graphSize;i++){

            for (int j = 0 ; j <= graphSize ;j++){

                if (i==j){
                    graphArray[i][j] = AlgNumber.ALG_INTEGER_INFINITE;
                    continue;
                }
                double r = Math.random();
                if ( r < sparseRate || sparseRate == 1.0){
                    graphArray[i][j] = 1;
                    graphArray[j][i] = 1;
                }
            }
        }
        return graphArray;
    }

    public static GraphList genNonDAGGraphList(int graphSize,double sparseRate){
        Integer[][] graphArray = genNonDAGGraphArray(graphSize,sparseRate);
        GraphList graphList = matrixToList(graphArray);
        return graphList;
    }

}
