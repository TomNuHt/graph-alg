package alg;

import interfaces.AlgNumber;
import pojo.GraphList;
import util.GraphTool;
import util.PrintLog;
import java.util.ArrayList;
import java.util.Map;

public class FordFulkson {

    public double maxFlowValue;

    public Double[][] cal(Double[][] graphArray, Map<String,Double> edgeCapacityMap,int sourceIndex,int targetIndex){
        //获取残存网络
        Double[][] graphArrayRemain = getRemainNetWork(graphArray,edgeCapacityMap);
        //把残存网络转成graphList
        GraphList graphListRemain = GraphTool.matrixToListWeight(graphArrayRemain);
        while (true){
            ArrayList<String> paths;
            try {
                //获取残存网络的增广路径，因为只关注联通性，所以权值的含义可以忽略
                paths = getArgumentPath(graphListRemain,sourceIndex,targetIndex);
//                System.out.println(paths);
            }
            catch (Exception e){
                break;
            }
            //根据残存网络以及增广路径，修改原图graphArray
            graphArray = addFlow(paths,graphArray,graphArrayRemain);
            //获取残存网络
            graphArrayRemain = getRemainNetWork(graphArray,edgeCapacityMap);
            //把残存网络转成graphList
            graphListRemain = GraphTool.matrixToListWeight(graphArrayRemain);
        }
        PrintLog.log("output graphArray:");
        PrintLog.printMatrix(graphArray);
        PrintLog.log("max flow value");
        PrintLog.log(getMaxFlowValue(graphArray,sourceIndex));
        maxFlowValue = getMaxFlowValue(graphArray,sourceIndex);
        return graphArray;
    }

    public double getMaxFlowValue(Double[][] graphArray, int sourceIndex){

        double outFlow = 0.0;
        double inFlow = 0.0;
        int matrixSize = graphArray.length;
        for (int i = 0 ; i < matrixSize;i++){

            if (!graphArray[sourceIndex][i].equals(AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY)){
                outFlow += graphArray[sourceIndex][i];
            }
        }

        for (int i = 0 ; i < matrixSize;i++){

            if (!graphArray[i][sourceIndex].equals(AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY)){
                inFlow += graphArray[i][sourceIndex];
            }
        }
        return outFlow - inFlow;


    }

    //根据增广路径修改graphArray
    public Double[][] addFlow(ArrayList<String> paths,Double[][] graphArray,Double[][] graphArrayRemain){

        ArrayList<String> edgeNameList = new ArrayList<String>();

        PrintLog.log("argument path：" + paths);

        String firstBefore = paths.get(0);
        //找到路径上的所有边
        for (int i = 1 ; i < paths.size();i++){
            String thisIndex = paths.get(i);
//            edgeNameList.add(firstBefore + "_" + thisIndex);
            edgeNameList.add(thisIndex + "_" + firstBefore);
            firstBefore = thisIndex;
        }
        double minFlow = AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY;
        //寻找路径上所有边中权重最小的
        for (int i=0 ; i < edgeNameList.size();i++){
            String edgeName = edgeNameList.get(i);
            String[] uvString = edgeName.split("_");
            int uIndex = Integer.parseInt(uvString[0]);
            int vIndex = Integer.parseInt(uvString[1]);
            double flowTemp = graphArrayRemain[uIndex][vIndex];
            if (flowTemp < minFlow){
                minFlow = flowTemp;
            }
        }

        PrintLog.log("minFlow " + minFlow);
        PrintLog.log("edgeNameList" + edgeNameList);
        //修改原graphArray
        PrintLog.log("begin to revise graphArray:");
        PrintLog.log("before:");
        PrintLog.printMatrix(graphArray);
        for (int i=0 ; i < edgeNameList.size();i++){
            String edgeName = edgeNameList.get(i);
            String[] uvString = edgeName.split("_");
            int uIndex = Integer.parseInt(uvString[0]);
            int vIndex = Integer.parseInt(uvString[1]);

            //如果该边在原图中不存在那么就是减小流
            if (graphArray[uIndex][vIndex].equals(AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY)){

                graphArray[vIndex][uIndex] -= minFlow;

            }
            else {

                graphArray[uIndex][vIndex]  += minFlow;

            }

        }
        PrintLog.log("after:");
//        PrintLog.logKey("测试");
        PrintLog.printMatrix(graphArray);
        return graphArray;
    }

    //获取增广路径
    public ArrayList<String> getArgumentPath(GraphList graphList,int sourceIndex,int targetIndex) throws Exception {
        DfsForFordFulkson dfsForFordFulkson = new DfsForFordFulkson();
        ArrayList<String> paths;
        try {
            paths = dfsForFordFulkson.search(graphList,sourceIndex,targetIndex);
            System.out.println(paths);
        }
        catch(Exception e){
            throw e;
        }
        return paths;
    }

    public Double[][] getRemainNetWork(Double[][] graphArray, Map<String,Double> edgeCapacityMap){

        PrintLog.log("begin to cal remain network:");
//        PrintLog.log("原网络");
//        PrintLog.printMatrix(graphArray);
        Double[][] remainNetWork = getEmptyGraphArray(graphArray);
        for ( int i = 0 ; i < graphArray.length;i++){

            for (int j = 0 ; j < graphArray.length;j++){
                Double volume = graphArray[i][j];
                if (volume.equals(AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY)){
                    continue;
                }

                String edgeName = i + "_" + j;
                PrintLog.log(edgeName);
                PrintLog.log(volume);
                Double capacity = edgeCapacityMap.get(edgeName);
                Double weightF = capacity - volume;
                if (!weightF.equals(0.0)){
                    remainNetWork[i][j] = weightF;
                }
                if (!volume.equals(0.0)){
                    remainNetWork[j][i] = volume;
                }
            }
        }

        PrintLog.log("remain network：");
        PrintLog.printMatrix(remainNetWork);
        PrintLog.log("calculate remain network end");
        return remainNetWork;
    }

    public Double[][] getEmptyGraphArray(Double[][] graphArray){
        Double[][] graphArrayNew = new Double[graphArray.length][graphArray.length];
        for (int i = 0 ; i < graphArrayNew.length;i++){

            for ( int j = 0 ; j < graphArrayNew.length;j++){
                graphArrayNew[i][j] = AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY;
            }
        }
        return graphArrayNew;
    }

}
