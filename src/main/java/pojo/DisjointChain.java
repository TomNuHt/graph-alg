package pojo;

public class DisjointChain {

    DisjointChainObject headObject;
    DisjointChainObject tailObject;


    public DisjointChainObject getHeadObject() {
        return headObject;
    }

    public void setHeadObject(DisjointChainObject headObject) {
        this.headObject = headObject;
    }

    public DisjointChainObject getTailObject() {
        return tailObject;
    }

    public void setTailObject(DisjointChainObject tailObject) {
        this.tailObject = tailObject;
    }

    public int getLength(){

        int counter = 0;
        boolean isEnd = false;
        DisjointChainObject firstChainObject = headObject;
        while (!isEnd){

            counter += 1;
            if (null != firstChainObject.getTail()){

                firstChainObject = firstChainObject.getTail();

            }else {

                isEnd = true;

            }


        }

        return counter;

    }
}
