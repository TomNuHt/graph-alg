package alg;

import interfaces.AlgColor;
import pojo.GraphList;
import util.PrintLog;

import java.util.ArrayList;

public class DfsKosaraju extends Dfs{


    ArrayList<Integer> leaveTimeList;

    public DfsKosaraju(ArrayList<Integer> leaveTimeList){
        this.leaveTimeList = leaveTimeList;
    }

    @Override
    public void search(GraphList graphList){

        this.graphList = graphList;

        int pointSize = this.graphList.returnList().size();
        initialGraph(pointSize);

        PrintLog.log(leaveTimeList);

        while (colorList.contains(AlgColor.ALG_COLOR_WHITE)){

            int nextIndex = findMaxLeaveTime(leaveTimeList);
            PrintLog.log( "colorlist is:"+ colorList + " nextIndex:" + nextIndex + " leave at: " + leaveTimeList.get(nextIndex));
            dfsCore(nextIndex);

        }

        PrintLog.log(pionList);

    }

    public int findMaxLeaveTime(ArrayList<Integer> leaveTimeList){

        int maxLeaveTime = 0;
        int maxLeaveTimeIndex = 0;

        for (int i = 0 ; i < leaveTimeList.size();i++){

            int time = leaveTimeList.get(i);
            if (colorList.get(i).equals(AlgColor.ALG_COLOR_WHITE) && time >= maxLeaveTime){

                maxLeaveTime = time;
                maxLeaveTimeIndex = i;

            }

        }

        return maxLeaveTimeIndex;

    }

}
