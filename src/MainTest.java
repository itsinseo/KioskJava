import java.util.Scanner;

public class MainTest {
    static Product pTest = new Product();

    public static void test1(){
        System.out.println("Hello");
    }

    public static void test2(){
        System.out.println("World!");
    }

    public static void test3(){
        System.out.println("World!");
    }

    public static void test4(){
        System.out.println("World!");
    }

    public static void main(String[] args) {
        test1();
        test2();

        Methods.test1();
        Methods.test2();

        System.out.println("\nbefore method:");
        System.out.printf("name: %s, desc: %s, price: %.2f\n", pTest.name, pTest.desc, pTest.price);

        Methods.productTest(pTest);
        System.out.println("\nafter method:");
        System.out.printf("name: %s, desc: %s, price: %.2f\n", pTest.name, pTest.desc, pTest.price);
    }
}