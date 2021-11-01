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
    public ArrayList<Map> bccGroups = new ArrayList<Map>();
    public ArrayList<Boolean> isCutPoint = new ArrayList<Boolean>();

    @Override
    public void dfsCore(int i){

        queue.add(i);//进队列
        PrintLog.log("第 " + i + " 个点进队列" );
        time = time + 1;
        PrintLog.log("时间：" + time);
        dfn[i] = time;
        low[i] = time;
        PrintLog.log("第 " + i + " 个点的初始dfn值为：" + dfn[i]);
        PrintLog.log("第 " + i + " 个点的初始low值为：" + low[i]);
        visitTime.set(i,time);
        colorList.set(i, AlgColor.ALG_COLOR_GRAY);
        PrintLog.log("将第 " +  i + " 个点的颜色设置为灰色");

        //链表
        ArrayList<Map> mapArrayList = this.graphList.returnList();

        //节点的链表
        Map<String,Object> map = mapArrayList.get(i);

        //与i相连的节点
        ArrayList<Integer> connectedList = (ArrayList<Integer>)map.get("connectedList");
        PrintLog.log("与第 " + i + " 个点相连的点有： " + connectedList);

        for (int j = 0 ; j < connectedList.size();j++){

            int indexJ = connectedList.get(j);
            PrintLog.log("搜索第 " + indexJ + " 个点");

            if (colorList.get(indexJ).equals(AlgColor.ALG_COLOR_WHITE)){//indexJ未被访问过
                PrintLog.log(indexJ + " 未被访问过");
                pionList.set(indexJ,String.valueOf(i));
                PrintLog.log("将 " + indexJ + " 点的父亲设置为： " + i);
                PrintLog.log("对 " + indexJ + " 进行dfs搜索");
                dfsCore(indexJ);
                PrintLog.log("第 " + indexJ + " 个点的dfs搜索完毕");
                PrintLog.log("开始调整第 " + i + " 个点的low值：");
                PrintLog.log("low[" + i + "] 为：" + low[i] + " low[" + indexJ + "]为：" + low[indexJ]);
                low[i] = Math.min(low[i],low[indexJ]);
                PrintLog.log("计算后 low[" +i + "]");

                //根节点为割点的充要条件是根节点有两个子节点
                if(i == 0 && connectedList.size() < 2){
                    PrintLog.log(i + " 为根节点，且 " + i + " 的儿子节点数量小于2，因此不进行后续的割点判断");
                    continue;
                }

                if(low[indexJ]>=dfn[i] && (Integer.valueOf(pionList.get(indexJ))==i)){

                    PrintLog.log(  indexJ + "的父结点为" + i);
                    PrintLog.log("《《《《《《《发现割点" + i);
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    PrintLog.log("开始计算连通分量：");
                    PrintLog.log("从栈顶删除元素，直到: " + indexJ);
                    for (int k = queue.size() - 1; k >=0; k--){

                        if (queue.get(k) == indexJ){
                            queue.remove(k);
                            arrayList.add(indexJ);
                            arrayList.add(i);
                            break;
                        }

                        arrayList.add(queue.get(k));
                        PrintLog.log("属于" + i + "的连通分量添加：" + queue.get(k));
                        queue.remove(k);
                        PrintLog.log("栈中删除" + k);
                        PrintLog.log("删除后的栈变为：" + queue);

                    }

                    PrintLog.log("属于" + i + "的连通分量添加完毕，分量为：" + arrayList);
                    Map map1 = new HashMap();
                    map1.put(i,arrayList);
                    bccGroups.add(map1);
                    isCutPoint.set(i,true);
                }

            }

            else {

                //已经访问过的点有两种可能，第一种i是indeJ的父辈，第二种，i是indexJ的子孙
                PrintLog.log("第 " + indexJ + " 个点已经被访问过");
                PrintLog.log("i is : " + i + " ,indexJ is: " + indexJ);
                int iFather = Integer.valueOf(pionList.get(i));

                if (iFather != indexJ ){
//                    PrintLog.log("第 " + indexJ + " 个点不是第 " + i + " 点的父节点，因此 ：" + i + "-" + indexJ + " 是一条返祖边" );
                    PrintLog.log("调整第 " + i + " 个的low值");
                    PrintLog.log("low[" + i + "] 为：" + low[i] + " dfn[" + indexJ + "]为：" + dfn[indexJ]);
                    low[i] = Math.min(low[i],dfn[indexJ]);
                    PrintLog.log("计算后 " + low[i]);

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
                    PrintLog.log("*******************把第" + i + "个节点设置为割点*****************");
                }

            }

        }



        colorList.set(i,AlgColor.ALG_COLOR_BLACK);
//        time = time + 1;
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
