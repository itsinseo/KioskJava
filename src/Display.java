import java.util.Scanner;

public class Display {
    public static int mainMenu(Menu[] menuArray) {
        //필수 1. 메인 메뉴판 화면
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
        //필수 2. 상품 메뉴판 화면
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
        //필수 3. 구매 화면
        Scanner sc = new Scanner(System.in);

        System.out.printf("\"%-20s | W %4.2f | %s\"\n", p.getName(), p.getPrice(), p.getDesc());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int n3 = sc.nextInt();
        if (n3 == 1) {
            //선택 1. 주문개수 기능 추가: 입력 부분
            System.out.println(p.getName() + " 가 장바구니에 추가되었습니다.");
            if (orders.getOrderMap().containsKey(p)) {
                System.out.println(orders.getOrderMap().get(p) + "개가 이미 카트에 있네요 주문 수량을 늘립니다.");
                orders.getOrderMap().replace(p, orders.getOrderMap().get(p) + 1);
            } else {
                System.out.println("카트에 없으니 새로 추가합니다.");
                orders.getOrderMap().put(p, 1);
            }
        }
    }

    public static void order(Order orders, Order sales) {
        //필수 4. 주문 화면
        Scanner sc = new Scanner(System.in);

        double totalPrice = 0;
        System.out.println("아래와 같이 주문 하시겠습니까? \n");
        System.out.println("[ Orders ]");
        for (Product p : orders.getOrderMap().keySet()) {
            System.out.printf("%-20s | W %4.2f | %d개 | %s\n", p.getName(), p.getPrice(), orders.getOrderMap().get(p), p.getDesc());
            totalPrice += p.getPrice() * orders.getOrderMap().get(p);
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.2f\n\n", totalPrice);

        System.out.println("1. 주문        2. 메뉴판");

        if (sc.nextInt() == 1) {
            orderComplete(orders, orders.getWaitNum(), sales);
        }
    }

    public static void orderComplete(Order orders, int waitNum, Order sales) {
        //필수 5. 주문완료 화면
        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + waitNum + " ] 번 입니다.");
        //선택 1. 주문개수 기능 추가: 출력 부분
        for (Product p : orders.getOrderMap().keySet()) {
            sales.getOrderMap().put(p, orders.getOrderMap().get(p));
            sales.setTotalSales(sales.getTotalSales() + p.getPrice() * sales.getOrderMap().get(p));
        }
        orders.getOrderMap().clear();

        try {
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        orders.setWaitNum(waitNum + 1);
    }

    public static void cancel(Order orders) {
        //필수 6. 주문취소 화면
        Scanner sc = new Scanner(System.in);

        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("진행하던 주문이 취소되었습니다.");
            orders.getOrderMap().clear();
        }
    }

    public static void totalSales(Order sales) {
        //선택 3. 총 판매금액 조회 기능 추가
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ W %.2f ] 입니다.\n\n", sales.getTotalSales());
    }

    public static void totalList(Order sales) {
        //선택 4. 총 판매상품 목록 조회 기능 추가
        Scanner sc = new Scanner(System.in);

        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
        for (Product p : sales.getOrderMap().keySet()) {
            System.out.printf("- %-20s | W %.2f | %d개\n", p.getName(), p.getPrice(), sales.getOrderMap().get(p));
        }
        System.out.println("\n1. 돌아가기");
        int n = sc.nextInt();
        if (n == 1) {
            return;
        }
    }
}