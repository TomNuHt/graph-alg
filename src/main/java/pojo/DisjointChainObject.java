package pojo;


//链表中的对象，head指向所属链表，tail指向后一个对象，链表中的最后一个对象指向空
public class DisjointChainObject {

    DisjointChain head;
    DisjointChainObject tail;
    Integer pointIndex;
    GraphList graphList;

    public DisjointChain getHead() {
        return head;
    }

    public void setHead(DisjointChain head) {
        this.head = head;
    }

    public DisjointChainObject getTail() {
        return tail;
    }

    public void setTail(DisjointChainObject tail) {
        this.tail = tail;
    }

    public Integer getPointIndex() {
        return pointIndex;
    }

    public void setPointIndex(Integer pointIndex) {
        this.pointIndex = pointIndex;
    }

    public GraphList getGraphList() {
        return graphList;
    }

    public void setGraphList(GraphList graphList) {
        this.graphList = graphList;
    }
}
