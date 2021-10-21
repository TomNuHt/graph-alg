package util;

public class SelfMathTool {

    public static Integer[][] transposit(Integer[][] array){

        Integer[][] arrayAfterTrans = new Integer[array[0].length][array.length];

        for (int i = 0 ; i < array.length;i++){

            for (int j = 0 ; j < array[0].length;j++){

                arrayAfterTrans[j][i] = array[i][j];


            }

        }

        return arrayAfterTrans;

    }

}
