package pojo;

import java.util.Map;

public class GraphMatrixWeight extends GraphMatrix{

    public Map edgeMap;
    public Double[][] graphArrayWeight;


    public GraphMatrixWeight(int rowSize,int colSize){
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.graphArray = new Integer[rowSize][colSize];
        initial();
    }

    //
    public Double[][] importEdgeMap(Map<String,Double> edgeMap){

        this.graphArrayWeight = new Double[rowSize][colSize];
        initialWeightGraph();
        for (String key:edgeMap.keySet()){

            int u = Integer.valueOf(key.split("_")[0]);
            int v = Integer.valueOf(key.split("_")[1]);
            double weight = edgeMap.get(key);
            graphArrayWeight[u][v] = weight;
        }
        return graphArrayWeight;
    }


    public void initialWeightGraph(){

        for (int i = 0 ; i < rowSize;i++) {
            for (int j = 0; j < colSize; j++) {
                graphArrayWeight[i][j] = Double.parseDouble(graphArray[i][j].toString());
            }
        }
    }


}
