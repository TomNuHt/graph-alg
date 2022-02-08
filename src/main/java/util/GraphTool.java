package util;

import interfaces.AlgNumber;
import pojo.GraphList;

import java.util.ArrayList;
import java.util.Map;

public class GraphTool {

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

    public static GraphList matrixToList(Double[][] graphArray){

        GraphList graphList = new GraphList();
        for (int i = 0 ; i < graphArray.length;i++){
            ArrayList<Integer> connectedList = new ArrayList<Integer>();
            for (int j = 0 ; j < graphArray[i].length;j++){
                if (graphArray[i][j] != Double.POSITIVE_INFINITY){
                    connectedList.add(j);
                }
            }
            graphList.buildListMap(i,connectedList);
        }
        return graphList;
    }

    public static GraphList matrixToListWeight(Double[][] graphArray){

        GraphList graphList = new GraphList();
        for (int i = 0 ; i < graphArray.length;i++){
            ArrayList<Integer> connectedList = new ArrayList<Integer>();
            for (int j = 0 ; j < graphArray[i].length;j++){
                if (graphArray[i][j] != AlgNumber.ALG_DOUBLE_INFINITE){
                    connectedList.add(j);
                }
            }
            graphList.buildListMap(i,connectedList);
        }
        return graphList;
    }

}
