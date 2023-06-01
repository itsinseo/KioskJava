import java.util.LinkedList;

public class Order {
    private LinkedList<Product> pList = new LinkedList<>();
    private int waitNum = 1;
    private double totalSales = 0;

    public int getWaitNum() {
        return waitNum;
    }

    public void setWaitNum(int waitNum) {
        this.waitNum = waitNum;
    }

    public LinkedList<Product> getpList() {
        return pList;
    }

    public void setpList(LinkedList<Product> pList) {
        this.pList = pList;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}