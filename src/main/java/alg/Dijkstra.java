package alg;

import interfaces.AlgNumber;
import pojo.GraphList;
import util.PrintLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

    public ArrayList<Double> sd = new ArrayList<Double>();
    public ArrayList<Integer> pai = new ArrayList<Integer>();
    ArrayList<Integer> gV = new ArrayList<Integer>();
    ArrayList<Integer> sList = new ArrayList<Integer>();
    ArrayList<Integer> q = new ArrayList<Integer>();


    public void cal(GraphList graphList, Map<String, Double> edgeMap, Integer sourceIndex){

        ArrayList<Map> graphMapList = graphList.returnList();
        Integer vertexSize = graphMapList.size();
        initialSingleSource(vertexSize,sourceIndex);
        while (null != q && q.size() > 1){

            q = remove(gV,sList);
            int u;
            if (q.size() == gV.size()){

                u = sourceIndex;

            }
            else {
                u = findU(sList,edgeMap,graphList);
            }
            sList.add(u);
            ArrayList<Integer> connU = getAdjUList(u,graphList);
            for (int i=0;i < connU.size();i++){

                int v = connU.get(i);
                double weight = edgeMap.get(u+"_"+v);
                relax(u,v,weight);
            }
        }
    }

    //找到和队列相连的最短那个点
    public int findU(ArrayList<Integer> sList,Map<String, Double> edgeMap,GraphList graphList){

        PrintLog.log(sList);
        Map<String,Double> map = new HashMap();
        for (int i = 0 ; i < sList.size(); i++){
            int sIndex = sList.get(i);
            ArrayList<Integer> connUList = getAdjUList(sIndex,graphList);
            for (int j = 0 ; j < connUList.size();j++){
                int connU = connUList.get(j);
                if (!sList.contains(connU)){
                    String key = sIndex + "_" + connU;
                    double weight = edgeMap.get(key);
                    map.put(key,weight);
                }
            }
        }

        PrintLog.log(map);
        double min  = AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY;
        String minKey = "";
        for (String key:map.keySet()){

            if (map.get(key) < min){

                min = map.get(key);
                minKey = key;
            }
        }
        PrintLog.log(minKey);
        int cl = Integer.parseInt(minKey.split("_")[1]);
        return cl;
    }


    public  ArrayList<Integer> getAdjUList(int u,GraphList graphList){


        ArrayList<Map> mapArrayList = graphList.returnList();
        ArrayList<Integer> conn = new ArrayList<Integer>();
        for (int i = 0 ; i < mapArrayList.size();i++){

            Map map1 = mapArrayList.get(i);
            int index = Integer.parseInt(map1.get("index").toString());
            if (index == u){

                conn = (ArrayList<Integer>)map1.get("connectedList");
                break;

            }

        }

        return conn;

    }
    //从list1中把list2去掉
    public ArrayList<Integer> remove(ArrayList<Integer> list1,ArrayList<Integer> list2){

        ArrayList<Integer> list3 = new ArrayList<Integer>();
        for (int i = 0 ; i < list1.size();i++){

            int temp = list1.get(i);
            if (!list2.contains(temp)){

                list3.add(temp);
            }

        }

        return list3;


    }

    public void relax(int u,int v,double weight){

        if (sd.get(v) > (sd.get(u) + weight)){
            sd.set(v,sd.get(u) + weight);
            pai.set(v,u);
        }
    }

    public void initialSingleSource(Integer vertexSize,Integer sourceIndex){

        for (int i = 0 ; i < vertexSize;i++){
            sd.add(AlgNumber.ALG_DOUBLE_POSITIVE_INFINITY);
            pai.add(AlgNumber.ALG_NIL_INTEGER);
            q.add(i);
            gV.add(i);
        }
        sd.set(sourceIndex,0.0);
    }
}
