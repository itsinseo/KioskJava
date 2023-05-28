public class Menu {
    String name;
    String desc;
    Product[] prods;

    public Menu() {
        name = "menu default name";
        desc = "menu default desc.";
    }

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Menu(String name, String desc, Product[] prods) {
        this.name = name;
        this.desc = desc;
        this.prods = prods;
    }
}
