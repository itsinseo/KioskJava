import java.util.LinkedHashMap;

public class Order {
    private LinkedHashMap<Product, Integer> orderMap = new LinkedHashMap<>();
    private int waitNum = 1;
    private double totalSales = 0;

    public int getWaitNum() {
        return waitNum;
    }

    public void setWaitNum(int waitNum) {
        this.waitNum = waitNum;
    }

    public LinkedHashMap<Product, Integer> getOrderMap() {
        return orderMap;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
}