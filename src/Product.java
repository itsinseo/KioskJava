public class Product extends Menu {
    private double price;
    private double option;

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

    public double getOption() {
        return option;
    }

    public void setOption(double option) {
        this.option = option;
    }
}
