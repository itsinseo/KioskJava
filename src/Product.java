public class Product extends Menu {
    double price;

    public Product() {
        super("Product default name", "Product default desc.");
        price = 777;
    }

    public Product(String name, String desc, double price) {
        super(name, desc);
        this.price = price;
    }
}
