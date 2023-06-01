import java.util.ArrayList;

public class Order {
    private ArrayList<Product> pList = new ArrayList<>();
    private Product p;
    private int waitNum = 1;

    public int getWaitNum() {
        return waitNum;
    }

    public void setWaitNum(int waitNum) {
        this.waitNum = waitNum;
    }

    public ArrayList<Product> getpList() {
        return pList;
    }

    public void setpList(ArrayList<Product> pList) {
        this.pList = pList;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }
}