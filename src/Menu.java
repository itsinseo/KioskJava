public class Menu {
    private String name;
    private String desc;
    private Product[] prods;

    public Menu(){
        name = "default name";
        desc = "default desc.";
    }

    public Menu(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public Menu(String name, String desc, Product[] prods) {
        this.name = name;
        this.desc = desc;
        this.prods = prods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Product[] getProds() {
        return prods;
    }

    public void setProds(Product[] prods) {
        this.prods = prods;
    }
}
