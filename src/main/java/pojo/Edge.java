package pojo;

public class Edge {

    Integer u;
    Integer v;
    Double weight;

    public Edge(Integer u,Integer v,Double weight){

        this.u = u;
        this.v = v;
        this.weight =weight;
    }

    public Integer getU() {
        return u;
    }

    public void setU(Integer u) {
        this.u = u;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
