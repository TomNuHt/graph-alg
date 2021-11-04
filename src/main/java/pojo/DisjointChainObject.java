package pojo;

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
