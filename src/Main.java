import java.util.Scanner;

public class Main {
    static Menu[] menuArray = Menu.initialize();
    static Order orders = new Order();
    static int waitNum = 1;

    public static void mainMenu() {
        // 1. 메인 메뉴판 화면
        System.out.println("\n\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuArray.length; i++) {
            System.out.printf("%d. %-20s | %s\n", i + 1, menuArray[i].name, menuArray[i].desc);
        }
        System.out.println("\n[ ORDER MENU ]");
        System.out.printf("%d. %-20s | %s", menuArray.length + 1, "Order", "장바구니를 확인 후 주문합니다.\n");
        System.out.printf("%d. %-20s | %s", menuArray.length + 2, "Cancel", "진행중인 주문을 취소합니다.\n\n");
    }

    public static void productMenu(int n1) {
        // 2. 상품 메뉴판 화면
        System.out.println("\n\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        System.out.printf("[ %s MENU ]\n", menuArray[n1].name);

        for (int i = 0; i < menuArray[n1].prods.length; i++) {
            Product p = menuArray[n1].prods[i];
            System.out.printf("%d. %-20s | W %4.2f | %s\n", i + 1, p.name, p.price, p.desc);
        }
    }

    public static void addToCartMenu(int n1, int n2) {
        // 3. 구매 화면
        Scanner sc = new Scanner(System.in);

        Product p = menuArray[n1].prods[n2];
        System.out.printf("\"%-20s | W %4.2f | %s\"\n", p.name, p.price, p.desc);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int n3 = sc.nextInt();
        if (n3 == 1) {
            System.out.println(p.name + " 가 장바구니에 추가되었습니다.");
            orders.pList.add(p);
        }

//        sc.close();
    }

    public static void order() {
        // 4. 주문 화면
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
    }

    public static void orderComplete() {
        // 5. 주문완료 화면
        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + waitNum + " ] 번 입니다.");
        orders.pList.clear();
        waitNum++;

        try {
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cancel() {
        // 6. 주문취소 화면
        Scanner sc = new Scanner(System.in);

        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("진행하던 주문이 취소되었습니다.");
            orders.pList.clear();
        }

//        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //키오스크는 무한 루프
        while (true) {
            //메인 메뉴
            mainMenu();

            //입력 받고 각 메뉴로
            int n1 = sc.nextInt() - 1;
            //hidden options for testing
            if (n1 == -1) {
                //break
                break;
            }

            if (n1 == menuArray.length) {
                if(orders.pList.isEmpty()) {
                    System.out.println("장바구니에 아무 것도 없습니다! 메인 메뉴로 돌아갑니다.");
                    continue;
                }
                //주문 메뉴
                order();

                int n3 = sc.nextInt();
                if (n3 == 1) {
                    orderComplete();
                } else if (n3 == 2) {
                    continue;
                } else {
                    System.out.println("입력 오류: 메뉴판으로 돌아갑니다.");
                }
            } else if (n1 == menuArray.length + 1) {
                //취소 메뉴
                cancel();
            } else {
                //상품 메뉴
                productMenu(n1);

                //구매(장바구니에 추가) 메뉴
                int n2 = sc.nextInt() - 1;
                addToCartMenu(n1, n2);
            }
        }

        sc.close();
    }
}