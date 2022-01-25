package alg;

import interfaces.AlgColor;
import pojo.GraphList;
import util.PrintLog;

import java.util.ArrayList;

public class DfsForFordFulkson extends Dfs{


    //返回的增广路径是从s到t的标号。
    public ArrayList<String> search(GraphList graphList,int sourceIndex,int endIndex) throws Exception {

        this.graphList = graphList;
        int pointSize = this.graphList.returnList().size();
        initialGraph(pointSize);

        ArrayList<String> pathIndexList = new ArrayList<String>();

        //从源点开始dfs搜索，如果能找到汇点，那么存在一条增广路径，如果不能找到，那么不存
        dfsCore(sourceIndex);

        String colorOfEndIndex = colorList.get(endIndex);
        if (colorOfEndIndex.equals(AlgColor.ALG_COLOR_WHITE)){

            throw new Exception("do not have a argument path!");

        }
        else {

            pathIndexList.add(String.valueOf(endIndex));

            int nextIndex = endIndex;
            while (true){


                int pai = pionList.indexOf(nextIndex);
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
