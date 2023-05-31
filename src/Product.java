public class Product extends Menu {
    double price;
    int amount = 1;

    public Product(String name, String desc, double price) {
        super(name, desc);
        this.price = price;
    }
}
