package alg;

import interfaces.AlgNumber;
import util.PrintLog;

import java.util.Map;

public class ExtendShortestPaths {

    public Double[][] l;
    public void cal(Double[][] graphArray){

        graphArray = reviseWarray(graphArray);
        int vertexSize = graphArray.length;
        l = initialL(vertexSize,graphArray);

        int counter = 1;
        while (counter <= vertexSize - 2 ){


            for (int i = 0 ; i < vertexSize;i++){
                for (int j= 0 ; j < vertexSize;j++){
                    //l-ik,w-kj
                    double minTemp = AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY;
                    for (int k = 0 ; k < vertexSize;k++){
                        double temp = l[i][k] + graphArray[k][j];
                        System.out.println(temp);
                        if (temp < minTemp){
                            minTemp = temp;
                        }
                    }

                    PrintLog.log(i + " " + j + " " + minTemp);
                    l[i][j] = minTemp;
                }
            }
            counter +=1;
        }
    }

    public Double[][] reviseWarray(Double[][] graphArray){

        int arrayLength = graphArray.length;
        for (int i = 0 ; i < arrayLength;i++){

            graphArray[i][i] = 0.0;

        }

        return graphArray;
    }

    public Double[][] initialL(int vertexSize,Double[][] graphArray){

        Double[][] l = new Double[vertexSize][vertexSize];
        for (int i= 0; i < vertexSize;i++){
            for (int j=0; j < vertexSize;j++){
                l[i][j] = graphArray[i][j];
            }
        }
        return l;
    }

    public void calUpgared(Double[][] graphArray){

        graphArray = reviseWarray(graphArray);
        int vertexSize = graphArray.length;
        Double[][] l = initialL(vertexSize,graphArray);
        int lnd1 = new Double(Math.ceil(Math.log(vertexSize - 1) / Math.log(2))).intValue();
        int counter = 1;
        while (counter <= lnd1){

            for (int i = 0 ; i < vertexSize;i++){

                for (int j= 0 ; j < vertexSize;j++){
                    //l-ik,w-kj
                    double minTemp = AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY;
                    for (int k = 0 ; k < vertexSize;k++){
                        double temp = l[i][k] + l[k][j];
                        if (temp < minTemp){
                            minTemp = temp;
                        }
                    }

                    l[i][j] = minTemp;
                }
            }
            counter +=1;
        }

        PrintLog.printMatrix(l);
    }

}
