package alg;

import interfaces.AlgColor;
import util.PrintLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DfsBccPoint extends Dfs{

    public Integer[] dfn;
    public Integer[] low;
    public ArrayList<Integer> queue = new ArrayList<Integer>();
    public ArrayList<Map> bccGroups = new ArrayList<Map>();
    public ArrayList<Boolean> isCutPoint = new ArrayList<Boolean>();

    @Override
    public void dfsCore(int i){

        queue.add(i);//进队列
        PrintLog.log("queue add i :" + i );
        PrintLog.log("queue now : " + queue);
        time = time + 1;
        dfn[i] = time;
        low[i] = time;
        visitTime.set(i,time);
        PrintLog.log("第" + time + "时刻访问第：" + i + "个点");
        colorList.set(i, AlgColor.ALG_COLOR_GRAY);
        PrintLog.log("将第" + i + "个点的颜色设置为灰色");

        //链表
        ArrayList<Map> mapArrayList = this.graphList.returnList();

        //节点的链表
        Map<String,Object> map = mapArrayList.get(i);

        //与i相连的节点
        ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");
        PrintLog.log("与" + i + "相连的有：" +connectedList);

        for (int j = 0 ; j < connectedList.size();j++){

            int indexJ = connectedList.get(j);
            PrintLog.log("开始搜索第" + indexJ + "个点");
            if (colorList.get(indexJ).equals(AlgColor.ALG_COLOR_WHITE)){//indexJ未被访问过
                PrintLog.log("第" + indexJ + "个点未被访问过");
                PrintLog.log("@@@@@@当前节点的父节点为：" + i + " @@@@@@");
                pionList.set(indexJ,String.valueOf(i));
                PrintLog.log("对第 " + indexJ + " 个点进行递归DFS");
                dfsCore(indexJ);
                PrintLog.log("第 " + indexJ + " 个的递归DFS已经完成");
                PrintLog.log("@@@@@@当前节点的父节点为：" + i + " @@@@@@");

                PrintLog.log("------------开始判断割点--------");

                low[i] = Math.min(low[i],low[indexJ]);
                if(low[indexJ]>=dfn[i]){

                    PrintLog.log("%%%%%%%%%%%%%%%%%%%%%%%%%发现割点 : " + i);
                    PrintLog.log("queue now:" + queue);
                    PrintLog.log("start build bcc----------------");

                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    for (int k = queue.size() - 1; k >=0; k--){

                        if (queue.get(k) == indexJ){
                            queue.remove(k);

                            PrintLog.log("find last,queue remove :" + indexJ);
                            arrayList.add(indexJ);
                            arrayList.add(i);
//                            continue;
                            break;
                        }

                        arrayList.add(queue.get(k));
                        PrintLog.log("bcc for " + i + " add:" + queue.get(k));
                        PrintLog.log("bcc for " + i + " now is:" + arrayList);
                        PrintLog.log("queue remove :" + queue.get(k));
                        queue.remove(k);
                        PrintLog.log("queue now:" + queue);

                    }

                    Map map1 = new HashMap();
                    map1.put(i,arrayList);
                    PrintLog.log("bcc " + i + " build sccess! points in this bcc is :" + arrayList);
                    bccGroups.add(map1);
                    isCutPoint.set(i,true);
                }

            }

            else {

                PrintLog.log("第" + indexJ + "个点已被访问过");
                low[i] = Math.min(low[i],dfn[indexJ]);

                if(low[indexJ]>=dfn[i] && !isCutPoint.get(i)){

                    PrintLog.log("find cut point: " + i);
                    PrintLog.log("start build bcc----------------");

                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    for (int k = queue.size() - 1; k >=0; k--){

                        if (queue.get(k) == indexJ){
                            queue.remove(k);

                            PrintLog.log("find last,queue remove :" + indexJ);
                            arrayList.add(indexJ);
                            arrayList.add(i);
//                            continue;
                            break;
                        }

                        arrayList.add(queue.get(k));
                        PrintLog.log("bcc for " + i + " add:" + queue.get(k));
                        PrintLog.log("bcc for " + i + " now is:" + arrayList);
                        PrintLog.log("queue remove :" + k);
                        queue.remove(k);
                        PrintLog.log("queue now:" + queue);

                    }

                    Map map1 = new HashMap();
                    map1.put(i,arrayList);
                    PrintLog.log("bcc " + i + " build sccess! points in this bcc is :" + arrayList);
                    bccGroups.add(map1);
                    isCutPoint.set(i,true);
                }

            }

        }



        colorList.set(i,AlgColor.ALG_COLOR_BLACK);
        PrintLog.log("将第" + i + "个点设置为黑色");
        time = time + 1;
        PrintLog.log("第" + i + "个点的离开时间为：" + time);
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
