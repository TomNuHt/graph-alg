package util;

import java.util.Date;

public class PrintLog {

    public static void log(Object object){

        System.out.println(new Date() + "----------" + object);

    }

    public static void printMatrix(Integer[][] matrix){

        for (int i = 0 ; i < matrix.length;i++){

            String temp = "";

            for (int j = 0 ; j < matrix[0].length;j++){

                temp = temp + " " + matrix[i][j];

            }
            System.out.println(temp);
        }

    }

    public static void printMatrix(Double[][] matrix){

        for (int i = 0 ; i < matrix.length;i++){

            String temp = "";

            for (int j = 0 ; j < matrix[0].length;j++){

                temp = temp + " " + matrix[i][j];

            }
            System.out.println(temp);
        }

    }

    public static void printArray(Integer[] array){

        String temp = "";

        for (int i = 0 ; i < array.length;i++){

            temp = temp + " " + array[i];

        }
        System.out.println(temp);
    }

    public static void printArray(Double[] array){

        String temp = "";

        for (int i = 0 ; i < array.length;i++){

            temp = temp + " " + array[i];

        }
        System.out.println(temp);
    }

}
