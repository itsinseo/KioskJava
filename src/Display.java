import java.util.Scanner;

public class Display {
    public static int mainMenu(Menu[] menuArray) {
        // 1. 메인 메뉴판 화면
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuArray.length; i++) {
            System.out.printf("%d. %-20s | %s\n", i + 1, menuArray[i].name, menuArray[i].desc);
        }
        System.out.println("\n[ ORDER MENU ]");
        System.out.printf("%d. %-20s | %s", menuArray.length + 1, "Order", "장바구니를 확인 후 주문합니다.\n");
        System.out.printf("%d. %-20s | %s", menuArray.length + 2, "Cancel", "진행중인 주문을 취소합니다.\n\n");

        return sc.nextInt();
    }

    public static int productMenu(Menu[] menuArray, int n1) {
        // 2. 상품 메뉴판 화면
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        System.out.printf("[ %s MENU ]\n", menuArray[n1].name);

        for (int i = 0; i < menuArray[n1].prods.length; i++) {
            Product p = menuArray[n1].prods[i];
            System.out.printf("%d. %-20s | W %4.2f | %s\n", i + 1, p.name, p.price, p.desc);
        }

        return sc.nextInt();
    }

    public static void addToCartMenu(Product p, Order orders) {
        // 3. 구매 화면
        Scanner sc = new Scanner(System.in);

        System.out.printf("\"%-20s | W %4.2f | %s\"\n", p.name, p.price, p.desc);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int n3 = sc.nextInt();
        if (n3 == 1) {
            System.out.println(p.name + " 가 장바구니에 추가되었습니다.");
            orders.pList.add(p);
        }
    }

    public static int order(Order orders) {
        // 4. 주문 화면
        Scanner sc = new Scanner(System.in);

        double totalPrice = 0;
        System.out.println("아래와 같이 주문 하시겠습니까? \n");
        System.out.println("[ Orders ]");
        for (Product p : orders.pList) {
            System.out.printf("%-20s | W %4.2f | %s\n", p.name, p.price, p.desc);
            totalPrice += p.price;
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.2f\n\n", totalPrice);

        System.out.println("1. 주문        2. 메뉴판");

        return sc.nextInt();
    }

    public static int orderComplete(Order orders, int waitNum) {
        // 5. 주문완료 화면
        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + waitNum + " ] 번 입니다.");
        orders.pList.clear();

        try {
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ++waitNum;
    }

    public static void cancel(Order orders) {
        // 6. 주문취소 화면
        Scanner sc = new Scanner(System.in);

        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("진행하던 주문이 취소되었습니다.");
            orders.pList.clear();
        }
        sc.close();
    }
}
