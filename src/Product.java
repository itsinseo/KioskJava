public class Product extends Menu {
    private double price;
    int amount = 1;

    public Product(String name, String desc, double price) {
        super(name, desc);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
