package alg;

import interfaces.AlgColor;
import util.PrintLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BccPoint extends Dfs{

    public Integer[] dfn;
    public Integer[] low;
    public ArrayList<Integer> queue = new ArrayList<Integer>();
    public ArrayList<Map> bccGroups = new ArrayList<Map>();//联通分量
    public ArrayList<Boolean> isCutPoint = new ArrayList<Boolean>();

    @Override
    public void dfsCore(int i){

        queue.add(i);//进队列
        PrintLog.log("add point:" + i + " into queue" );
        time = time + 1;
        PrintLog.log("time：" + time);
        dfn[i] = time;
        low[i] = time;
        PrintLog.log("set dfn of point:" + i + " to " + dfn[i]);
        PrintLog.log("set low of point: " + i + " to " + low[i]);
        visitTime.set(i,time);
        colorList.set(i, AlgColor.ALG_COLOR_GRAY);
        PrintLog.log("set color of point:" +  i + " to gray");

        //链表
        ArrayList<Map> mapArrayList = this.graphList.returnList();

        //节点的链表
        Map<String,Object> map = mapArrayList.get(i);

        //与i相连的节点
        ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");
        PrintLog.log("adj of point:" + i + " are " + connectedList);

        for (int j = 0 ; j < connectedList.size();j++){

            int indexJ = connectedList.get(j);
            PrintLog.log("search point:" + indexJ);

            if (colorList.get(indexJ).equals(AlgColor.ALG_COLOR_WHITE)){//indexJ未被访问过
                PrintLog.log(indexJ + " is never visited");
                pionList.set(indexJ,String.valueOf(i));
                PrintLog.log("set father node of point:" + indexJ + " to point:" + i);
                PrintLog.log("dfs search point:" + indexJ);
                dfsCore(indexJ);
                PrintLog.log("point:" + indexJ + " is searched");
                PrintLog.log("begin to revise the low of point:" + i);
                PrintLog.log("low[" + i + "] is：" + low[i] + " low[" + indexJ + "] is：" + low[indexJ]);
                low[i] = Math.min(low[i],low[indexJ]);
                PrintLog.log("after calculate low[" +i + "]:" + low[i]);

                //根节点为割点的充要条件是根节点有两个子节点
                if(i == 0 && connectedList.size() < 2){
                    PrintLog.log("point:" + i + " is root,and the number of the son of point:" + i + " is little than two,so point:" + i + " is not a cut point");
                    continue;
                }

                if(low[indexJ]>=dfn[i] && (Integer.valueOf(pionList.get(indexJ))==i)){

                    PrintLog.log(  "the father point of point:" + indexJ + " is point:" + i);
                    PrintLog.log("find cut point:" + i);
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    PrintLog.log("begin to calculate connected component：");
                    PrintLog.log("begin to delete the object on the top of stack until point:" + indexJ);
                    for (int k = queue.size() - 1; k >=0; k--){

                        if (queue.get(k) == indexJ){
                            queue.remove(k);
                            arrayList.add(indexJ);
                            arrayList.add(i);
                            break;
                        }

                        arrayList.add(queue.get(k));
                        PrintLog.log("the connected component of cut point:" + i + " add point:" + queue.get(k));
//                        PrintLog.log("属于" + i + "的连通分量添加：" + queue.get(k));
                        queue.remove(k);
                        PrintLog.log("delete point:" + k + " from stack");
                        PrintLog.log("after deleted,the stack is：" + queue);

                    }

                    PrintLog.log("the connected component of cut point:" + i + " is " + arrayList);
                    Map map1 = new HashMap();
                    map1.put(i,arrayList);
                    bccGroups.add(map1);
                    isCutPoint.set(i,true);
                }

            }

            else {

                //已经访问过的点有两种可能，第一种i是indeJ的父辈，第二种，i是indexJ的子孙
                PrintLog.log("point:" + indexJ + " was already visited");
                PrintLog.log("i is : " + i + " ,indexJ is: " + indexJ);
                Boolean isFather = true;
                if (pionList.get(i).equals("nil")){

                    isFather = false;

                }else if (Integer.valueOf(pionList.get(i)) != indexJ){

                    isFather = false;

                }

                if (!isFather ){
                    PrintLog.log("revise low of point:" + i);
                    PrintLog.log("low[" + i + "] is：" + low[i] + " dfn[" + indexJ + "] is：" + dfn[indexJ]);
                    low[i] = Math.min(low[i],dfn[indexJ]);
                    PrintLog.log( "low[" + i + "] after calculated:" + low[i]);

                }


                if(low[indexJ]>=dfn[i] && !isCutPoint.get(i) && (indexJ - i == 1)){
                    
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    for (int k = queue.size() - 1; k >=0; k--){

                        if (queue.get(k) == indexJ){
                            queue.remove(k);

                            arrayList.add(indexJ);
                            arrayList.add(i);
//                            continue;
                            break;
                        }

                        arrayList.add(queue.get(k));
                        queue.remove(k);

                    }

                    Map map1 = new HashMap();
                    map1.put(i,arrayList);
                    bccGroups.add(map1);
                    isCutPoint.set(i,true);
                    PrintLog.log("set point:" + i + " to cut point");
                }

            }

        }



        colorList.set(i,AlgColor.ALG_COLOR_BLACK);
        leaveTime.set(i,time);

    }


    //初始化
    @Override
    public void initialGraph(int pointSize){

        dfn = new Integer[pointSize];
        low = new Integer[pointSize];

        for (int i = 0; i < pointSize; i++){

            colorList.add(AlgColor.ALG_COLOR_WHITE);
            disList.add(Double.POSITIVE_INFINITY);
            isCutPoint.add(false);
            pionList.add("nil");
            visitTime.add(0);
            leaveTime.add(0);
            dfn[i] = 0;
            low[i] = 0;

        }

    }




}
