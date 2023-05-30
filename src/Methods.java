public class Methods {
    public static void test1(){
        System.out.println("Methods: Hello");
    }
    public static void test2(){
        System.out.println("Methods: World!");
    }

    public static void productTest(Product p){
        p.name = "changedName";
        p.desc = "changedName";
        p.price = 55555;
    }
}

