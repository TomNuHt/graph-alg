package pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//图的链表表示
public class GraphList {

    ArrayList<Map> graphLists = new ArrayList<Map>();
    Map<Integer,ArrayList<Integer>> graphMap = new HashMap();

    public ArrayList<Map> returnList(){

        return graphLists;

    }


    public Map returnMap(){
        return graphMap;
    }

    public void buildListMap(Integer vertexIndex,ArrayList<Integer> vertexIndexListConnectedTo){
        Map map = new HashMap();
        map.put("index",vertexIndex);
        map.put("connectedList",vertexIndexListConnectedTo);
        graphMap.put(vertexIndex,vertexIndexListConnectedTo);
        graphLists.add(map);
    }

}
