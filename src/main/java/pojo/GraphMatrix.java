package pojo;

//import Jama.Matrix;

import interfaces.AlgNumber;

import java.util.Map;

public class GraphMatrix {



//    public Matrix graphMatrix;
    public Integer[][] graphArray;
    public int colCounter = 0 ;

    public int rowSize;
    public int colSize;

    public GraphMatrix(){

    }

    public GraphMatrix(int rowSize,int colSize){

        this.rowSize = rowSize;
        this.colSize = colSize;
        this.graphArray = new Integer[rowSize][colSize];
        initial();

    }

    public void addConnected(String line){

        addConnectedCore(colCounter,line);
        colCounter = colCounter + 1;


    }

    public void addConnectedCore(int row,String line){

        String[] lineArray = line.split("\\s+");
        for (int i = 0 ; i < lineArray.length;i++){
            int value =Integer.valueOf(lineArray[i]);
            graphArray[row][value] = 1;
        }




    }

    public void initial(){

        for (int i = 0 ; i < rowSize;i++){

            for (int j = 0 ; j < colSize;j++){

                graphArray[i][j] = AlgNumber.ALG_INTEGER_INFINITE;

            }

        }


    }

    public Integer[][] returnMatrix(){

        return graphArray;

    }
}
