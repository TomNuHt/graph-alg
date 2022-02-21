package alg;

import interfaces.AlgNumber;
import pojo.GraphList;

import java.util.ArrayList;
import java.util.Map;

public class BellmanFord {

    public ArrayList<Double> sd = new ArrayList<Double>();//distance between source index and the other point
    public ArrayList<Integer> pai = new ArrayList<Integer>();

    //edgemap,key(u_v):value(权重)  u_v:从u指向v
    public boolean cal(GraphList graphList, Map<String, Double> edgeMap, Integer sourceIndex){

        ArrayList<Map> graphMapList = graphList.returnList();
        Integer vertexSize = graphMapList.size();

        //初始化
        initialSingleSource(vertexSize,sourceIndex);

        //算法主流程
        for (int i= 1 ; i <= vertexSize - 1;i++){

            for (String key:edgeMap.keySet()){

                int u = Integer.parseInt(key.split("_")[0]);
                int v = Integer.parseInt(key.split("_")[1]);
                double weight = edgeMap.get(key);
                relax(u,v,weight);
            }
        }


        boolean hasNegCircle = false;
        //判断是否含有经过源点的负权圈
        for (String key:edgeMap.keySet()){

            int u = Integer.parseInt(key.split("_")[0]);
            int v = Integer.parseInt(key.split("_")[1]);
            double weight = edgeMap.get(key);
            if (sd.get(v) > (sd.get(u) + weight)){
                hasNegCircle = true;
                break;
            }

        }

        return hasNegCircle;

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
        }
        sd.set(sourceIndex,0.0);
    }

}
