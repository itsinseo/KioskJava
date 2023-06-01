import java.util.Scanner;

public class Display {
    public static int mainMenu(Menu[] menuArray) {
        // 1. 메인 메뉴판 화면
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuArray.length; i++) {
            System.out.printf("%d. %-20s | %s\n", i + 1, menuArray[i].getName(), menuArray[i].getDesc());
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
        System.out.printf("[ %s MENU ]\n", menuArray[n1].getName());

        for (int i = 0; i < menuArray[n1].getProds().length; i++) {
            Product p = menuArray[n1].getProds()[i];
            System.out.printf("%d. %-20s | W %4.2f | %s\n", i + 1, p.getName(), p.getPrice(), p.getDesc());
        }

        return sc.nextInt();
    }

    public static void addToCartMenu(Product p, Order orders) {
        // 3. 구매 화면
        Scanner sc = new Scanner(System.in);

        System.out.printf("\"%-20s | W %4.2f | %s\"\n", p.getName(), p.getPrice(), p.getDesc());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int n3 = sc.nextInt();
        if (n3 == 1) {
            System.out.println(p.getName() + " 가 장바구니에 추가되었습니다.");
            if (orders.getpList().contains(p)) {
                p.setAmount(p.getAmount() + 1);
            } else {
                orders.getpList().add(p);
            }
        }
    }

    public static void order(Order orders, Order sales) {
        // 4. 주문 화면
        Scanner sc = new Scanner(System.in);

        double totalPrice = 0;
        System.out.println("아래와 같이 주문 하시겠습니까? \n");
        System.out.println("[ Orders ]");
        for (Product p : orders.getpList()) {
            System.out.printf("%-20s | W %4.2f | %d개 | %s\n", p.getName(), p.getPrice(), p.getAmount(), p.getDesc());
            totalPrice += p.getPrice() * p.getAmount();
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.2f\n\n", totalPrice);

        System.out.println("1. 주문        2. 메뉴판");

        if (sc.nextInt() == 1) {
            orderComplete(orders, orders.getWaitNum(), sales);
        }
    }

    public static void orderComplete(Order orders, int waitNum, Order sales) {
        // 5. 주문완료 화면
        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + waitNum + " ] 번 입니다.");
        for (Product p : orders.getpList()) {
            sales.getpList().add(p);
            sales.setTotalSales(sales.getTotalSales() + p.getPrice() * p.getAmount());
        }
        orders.getpList().clear();

        try {
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        orders.setWaitNum(waitNum + 1);
    }

    public static void cancel(Order orders) {
        // 6. 주문취소 화면
        Scanner sc = new Scanner(System.in);

        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("진행하던 주문이 취소되었습니다.");
            orders.getpList().clear();
        }
    }

    public static void totalSales(Order sales){
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ %.2f ] 입니다.\n\n", sales.getTotalSales());
    }

    public static void totalList(Order sales){
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
        for(Product p: sales.getpList()){
            System.out.printf("- %-20s | W %.2f | %d개\n", p.getName(), p.getPrice(), p.getAmount());
        }
        System.out.println("\n자동으로 메인 화면으로 돌아갑니다.");
    }
}