package pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//图的链表表示
public class GraphList {

    ArrayList<Map> graphLists = new ArrayList<Map>();

    public ArrayList<Map> returnList(){

        return graphLists;

    }

    public void buildListMap(Integer vertexIndex,ArrayList<Integer> vertexIndexListConnectedTo){
        Map map = new HashMap();
        map.put("index",vertexIndex);
        map.put("connectedList",vertexIndexListConnectedTo);
        graphLists.add(map);

    }

}
