public class Product extends Menu {
    double price;
    int amount = 1;

    public Product() {
        super("Product default name", "Product default desc.");
        price = 777;
    }

    public Product(String name, String desc, double price) {
        super(name, desc);
        this.price = price;
    }
}
