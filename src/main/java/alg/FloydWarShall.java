package alg;

import interfaces.AlgNumber;
import pojo.GraphMatrix;
import util.PrintLog;

import java.util.ArrayList;
import java.util.Random;

public class FloydWarShall {

    public void cal(Double[][] graphArray){



        graphArray = reviseWarray(graphArray);

        PrintLog.printMatrix(graphArray);

        int graphSize = graphArray.length;

        Double[][] d0 = initialD(graphArray);
        String[][] pai0 = initialPai(graphArray);

        PrintLog.printMatrix(pai0);
        ArrayList<Double[][]> dList = new ArrayList<Double[][]>();
        dList.add(d0);
        ArrayList<String[][]> pList = new ArrayList<String[][]>();
        pList.add(pai0);

        for (int k = 1 ; k < (graphSize + 1);k++){

            Double[][] dBefore = dList.get(k-1);
            String[][] paiBefore = pList.get(k-1);
            Double[][] d = getEmptyD(graphSize);
            String[][] pai = copyPai(paiBefore);

            for (int i = 0 ; i < graphSize;i++){


                for (int j = 0 ; j < graphSize;j++){

                    double dijBefore = dBefore[i][j];
                    double dikBefore = dBefore[i][k - 1];
                    double dkjBefore = dBefore[k - 1][j];
                    String paikjBefore = paiBefore[k  - 1][j];
                    String paiijBefore = paiBefore[i][j];

                    d[i][j] = Math.min(dijBefore,(dikBefore + dkjBefore));
                    if (k == 1 && i == 0 && j == 3){

                        PrintLog.log(dijBefore + " " + (dikBefore + dkjBefore));

                    }

                    if (dijBefore > (dikBefore + dkjBefore)){
                        pai[i][j] = paikjBefore ;
                    }
                    else {
                        pai[i][j] = paiijBefore;
                    }

                }
            }
            dList.add(d);
            pList.add(pai);

            PrintLog.log("-------------");
            PrintLog.log("k = " + k);
            PrintLog.log("d" + k);
            PrintLog.printMatrix(d);
            PrintLog.log("-------------");
            PrintLog.log("pai " + k);
            PrintLog.printMatrix(pai);

        }

        PrintLog.printMatrix(dList.get(graphSize - 1));
        PrintLog.printMatrix(pList.get(graphSize - 1));
    }

    public Double[][] reviseWarray(Double[][] graphArray){

        int arrayLength = graphArray.length;
        for (int i = 0 ; i < arrayLength;i++){

            graphArray[i][i] = 0.0;

        }

        return graphArray;
    }


    public String[][] copyPai(String[][] pai){

        String[][] newPai = new String[pai.length][pai.length];
        for (int i=0;i < pai.length;i++){
            for (int j  = 0 ; j < pai.length;j++){
                 newPai[i][j] = pai[i][j];
            }
        }
        return newPai;
    }

    public Double[][] getEmptyD(int size){

        Double[][] d = new Double[size][size];
        for (int i = 0 ; i < size;i++){

            for (int j = 0; j < size;j++){

                d[i][j] = 0.0;
            }
        }
        return d;
    }

    public Double[][] initialD(Double[][] graphArray){

        Double[][] d = new Double[graphArray.length][graphArray.length];
        for (int i = 0 ; i < graphArray.length;i++){

            for (int j = 0; j < graphArray.length;j++){

                d[i][j] = graphArray[i][j];
            }
        }
        return d;

    }




    public String[][] initialPai(Double[][] graphArray){

        String[][] pai = new String[graphArray.length][graphArray.length];
        for (int i = 0 ; i < graphArray.length;i++){

            for (int j = 0 ; j < graphArray.length;j++){

                if (graphArray[i][j].equals(AlgNumber.ALG_DOUBLE_INFINITE) || i==j){

                    pai[i][j] = "NIL";
//                    pai[i][j] = String.valueOf(i);

                }
                else {
                    pai[i][j] = String.valueOf(i);
                }
            }
        }



        return pai;
    }

}
