package alg;

import interfaces.AlgNumber;
import pojo.Edge;
import util.PrintLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Prim {

    ArrayList<Integer> points;
    ArrayList<Integer> connectedPoints = new ArrayList<Integer>();
    ArrayList<Edge> edges = new ArrayList<Edge>();

    public void search(Double[][] graphArray){

        initialPoints(graphArray.length);
        //随机选取一个点
        Random random = new Random();
        int firstPointIndex = random.nextInt(graphArray.length);
//        PrintLog.log(firstPointIndex);
        //加入connectedPoints
        connectedPoints.add(firstPointIndex);
        //找到与connectedPoints相连的边最短的点，把那条边加入到edges，把点加入到connectedpoints
        while (connectedPoints.size()!= graphArray.length){

            Map map = calCore(connectedPoints,graphArray);
            int index = Integer.valueOf(map.get("points").toString());
            Edge edge = (Edge) map.get("edge");
            connectedPoints.add(index);
            edges.add(edge);

        }
        for (int i= 0;i<edges.size();i++){

            Edge edge = edges.get(i);
            PrintLog.log(edge.getU() + "_" + edge.getV() + " weight: " + edge.getWeight());

        }
    }

    public Map calCore(ArrayList<Integer> connectedPoints,Double[][] graphArray){

        Map<String,Double> edgesMap = new HashMap();
        ArrayList<Integer> connectedOutSidePoints = new ArrayList<Integer>();
        //找到所有与当前connectedPoints相连的外部的点
        for (int i = 0;i < connectedPoints.size();i++){
            int index = connectedPoints.get(i);
            for (int j = 0 ; j < graphArray.length;j++){
                double weight = graphArray[index][j];
                if (weight != AlgNumber.ALG_DOUBLE_INFINITE && !connectedPoints.contains(j)){
                    connectedOutSidePoints.add(j);
                    edgesMap.put(i +"_"+ j,weight);
                }
            }
        }

        ArrayList<Map> mapArrayList = sort(edgesMap);
        Map shortestMap = mapArrayList.get(0);
        String key = shortestMap.get("u_v").toString();
        int u = Integer.parseInt(key.split("_")[0]);
        int v = Integer.parseInt(key.split("_")[1]);
        Double weight = (Double) shortestMap.get("weight");
        Edge edge = new Edge(u,v,weight);
        Map result = new HashMap();
        result.put("points",key.split("_")[1]);
        result.put("edge",edge);
        return result;
    }

    public ArrayList<Map> sort(Map<String,Double> edgesMap){

        String[] u_v = new String[edgesMap.size()];
        Double[] weight = new Double[edgesMap.size()];
        Integer[] num = new Integer[edgesMap.size()];

        int counter = 0;
        for (String key : edgesMap.keySet()){
            u_v[counter] = key;
            weight[counter] = edgesMap.get(key);
            num[counter] = counter;
            counter +=1;
        }


        for (int i=(edgesMap.size()-1); i>=1 ; i--){

            for (int j = 0 ; j < i ; j++){

                double jWeight = weight[j];
                double j1Weight = weight[j+1];
                if (jWeight >= j1Weight){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                    double tempW = weight[j];
                    weight[j] = weight[j+1];
                    weight[j+1] = tempW;
                }
            }
        }

        ArrayList<Map> mapArrayList = new ArrayList<Map>();
        for (int i = 0 ; i < num.length;i++){
            Map map = new HashMap();
            map.put("u_v",u_v[num[i]]);
            map.put("weight",weight[i]);
            mapArrayList.add(map);
        }
        return mapArrayList;
    }

    public void initialPoints(int size){

        points = new ArrayList<Integer>();
        for (int i=0;i < size;i++){
            points.add(i);
        }

    }


}
