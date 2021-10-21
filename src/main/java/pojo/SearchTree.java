package pojo;

import java.util.ArrayList;


//搜索树对象
public class SearchTree {

    public Integer index;
    public ArrayList<Object> otherInfo;
    public ArrayList<SearchTree> children;


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public ArrayList<Object> getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(ArrayList<Object> otherInfo) {
        this.otherInfo = otherInfo;
    }

    public ArrayList<SearchTree> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<SearchTree> children) {
        this.children = children;
    }
}
