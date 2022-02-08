package alg;

import interfaces.AlgColor;
import pojo.GraphList;
import util.PrintLog;

import java.util.ArrayList;

public class DfsForFordFulkson extends Dfs{


    //返回的增广路径是从s到t的标号。
    public ArrayList<String> search(GraphList graphList,int sourceIndex,int endIndex) throws Exception {

        PrintLog.log("开始寻找增广路径，源结点为：" + sourceIndex + " 汇结点为：" + endIndex);
        this.graphList = graphList;
        int pointSize = this.graphList.returnList().size();
        initialGraph(pointSize);
        ArrayList<String> pathIndexList = new ArrayList<String>();

        //从源点开始dfs搜索，如果能找到汇点，那么存在一条增广路径，如果不能找到，那么不存
        dfsCore(sourceIndex);
        PrintLog.log("从源结点开始深度优先搜索结束");
        PrintLog.log(colorList);
        PrintLog.log(pionList);
        String colorOfEndIndex = colorList.get(endIndex);
        if (colorOfEndIndex.equals(AlgColor.ALG_COLOR_WHITE)){
            throw new Exception("do not have a argument path!");

        }
        else {


            PrintLog.log(String.valueOf(endIndex));
            pathIndexList.add(String.valueOf(endIndex));
            int nextIndex = endIndex;
            while (true){
//                PrintLog.log(pathIndexList);
                int pai = Integer.valueOf(pionList.get(nextIndex));
//                int pai = pionList.indexOf(String.valueOf(nextIndex));
                PrintLog.log(pai);
                pathIndexList.add(String.valueOf(pai));

                if (pai == sourceIndex){

                    break;

                }
                nextIndex = pai;
            }

        }

        PrintLog.log("深度优先搜索树：" + pionList);
        return pathIndexList;

    }


}
