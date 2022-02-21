package alg;

import interfaces.AlgColor;
import pojo.GraphList;
import util.PrintLog;

import java.util.ArrayList;

public class DfsKosaraju extends Dfs{


    ArrayList<Integer> leaveTimeList;
    public ArrayList<ArrayList<Integer>> sccs = new ArrayList<ArrayList<Integer>>();
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

            ArrayList<String> colorListBefore = getCopyColorList(colorList);
            int nextIndex = findMaxLeaveTime(leaveTimeList);
            PrintLog.log( "colorlist is:"+ colorList + " nextIndex:" + nextIndex + " leave at: " + leaveTimeList.get(nextIndex));
            dfsCore(nextIndex);
            ArrayList<Integer> strongConnectedComponent = findDiffColorList(colorListBefore,colorList);
            sccs.add(strongConnectedComponent);
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

    ArrayList<Integer> findDiffColorList(ArrayList<String> colorListBefore,ArrayList<String> colorListAfter){

        ArrayList<Integer> indexs = new ArrayList<Integer>();
        for (int i = 0 ; i < colorListBefore.size();i++){
            if (!colorListAfter.get(i).equals(colorListBefore.get(i))){
                indexs.add(i);
            }
        }
        return indexs;
    }

    ArrayList<String> getCopyColorList(ArrayList<String> colorList){

        ArrayList<String> colorListCopy = new ArrayList<String>();
        for(int i=0; i<colorList.size();i++){
            colorListCopy.add(colorList.get(i));
        }
        return  colorListCopy;
    }
}
