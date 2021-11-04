package alg;

import pojo.DisjointChain;
import pojo.DisjointChainObject;
import pojo.Edge;
import pojo.GraphList;
import util.GraphTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kruskal {

    GraphList graphList;
    Double[][] graphArray;
    ArrayList<DisjointChain> chains = new ArrayList<DisjointChain>();
    ArrayList<DisjointChainObject> chainObjects = new ArrayList<DisjointChainObject>();
    Map<String,Double> edgesMap = new HashMap();
    Double[][] graphArraySmall;

    ArrayList<Edge> a = new ArrayList<Edge>();

    public void initialGraphArraySmall(int length){

        this.graphArraySmall = new Double[length][length];
        for (int i = 0 ; i < length ; i++){

            for (int j = 0 ; j < length;j++){

                graphArraySmall[i][j] = 0.0;

            }

        }

    }


    public void search(Double[][] graphArray){

        this.graphArray = graphArray;
        initialGraphArraySmall(graphArray.length);
        this.graphList = GraphTool.matrixToList(graphArray);
        makeSet();
        makeEdges();
        ArrayList<Map> edgeList = sort();

        //从权重最小的边开始
        for (int i = 0 ; i < edgeList.size();i++){

            Map edgeTemp = edgeList.get(i);
            String u_v = edgeTemp.get("u_v").toString();
            int u = Integer.parseInt(u_v.split("_")[0]);
            int v = Integer.parseInt(u_v.split("_")[1]);
            double weight = Double.parseDouble(edgeTemp.get("weight").toString());
            if (findSet(u).equals(findSet(v))){

                continue;

            }
            else {

                Edge edge = new Edge(u,v,weight);
                graphArraySmall[u][v] = weight;
                graphArraySmall[v][u] = weight;
                a.add(edge);
                union(u,v);

            }

        }


    }

    public void makeSet(){

        ArrayList<Map> mapArrayList = graphList.returnList();

        for (int i = 0 ; i < mapArrayList.size();i++){

            Map map = mapArrayList.get(i);
            Integer index =Integer.valueOf(map.get("index").toString());

            DisjointChainObject disjointChainObject = new DisjointChainObject();
            disjointChainObject.setPointIndex(index);
            disjointChainObject.setGraphList(graphList);
            DisjointChain disjointChain = new DisjointChain();
            disjointChain.setHeadObject(disjointChainObject);
            disjointChain.setTailObject(disjointChainObject);
            disjointChainObject.setHead(disjointChain);
            chains.add(disjointChain);
            chainObjects.add(disjointChainObject);


        }

    }

    public void makeEdges(){

        for (int i = 0 ; i < graphArray.length;i++){

            for (int j  = i ; j < graphArray[0].length;j++){

                String edgeKey = i + "_" + j;
                double weight = graphArray[i][j];
                edgesMap.put(edgeKey,weight);
            }
        }
    }

    public ArrayList<Map> sort(){

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

        for (int i = u_v.length;i>=1;i--){
            for (int j = 0 ; j < i ; j++){
                double jWeight = weight[j];
                double j1Weight =weight[j+1];
                if (jWeight >= j1Weight){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }

            }
        }


        ArrayList<Map> mapArrayList = new ArrayList<Map>();
        for (int i = 0 ; i < num.length;i++){

            Map map = new HashMap();
            map.put("u_v",u_v[num[i]]);
            map.put("weight",weight[num[i]]);
            mapArrayList.add(map);
        }

        return mapArrayList;

    }

    public DisjointChain findSet(int u){


        DisjointChainObject disjointChainObject = new DisjointChainObject();
        for (int i = 0 ; i < chainObjects.size();i++){

            DisjointChainObject chainObjectTemp = chainObjects.get(i);
            if (chainObjectTemp.getPointIndex() == u){
                disjointChainObject = chainObjectTemp;
                break;
            }

        }

        return disjointChainObject.getHead();

    }

    public void union(int u,int v){

        DisjointChain disjointChainU = findSet(u);
        DisjointChain disjointChainV = findSet(v);

        if (disjointChainU.getLength() > disjointChainV.getLength()){

            unionCore(disjointChainU,disjointChainV);

        }
        else {

            unionCore(disjointChainV,disjointChainU);
        }

    }


    //u的链表长度比v的大
    public DisjointChain unionCore(DisjointChain u,DisjointChain v){

        //修改chains,chainsObjects


        //将u链表的tail指向v中的最后一个节点
        u.getTailObject().setTail(v.getHeadObject());

        //将u中原本的最后一个节点指向v的第一个节点
        u.setTailObject(v.getTailObject());

        //将v链表中的每个节点修改为指向链表u

        DisjointChainObject vFirst = v.getHeadObject();
        vFirst.setHead(u);

        boolean isEnd = false;
        while (!isEnd){


            vFirst.getTail().setHead(u);
            vFirst = vFirst.getTail();
            if (null == vFirst){

                isEnd = true;

            }

        }

        return u;

    }



}
