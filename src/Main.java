import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0. 데이터 초기화: 일단 Burgers, Frozen Custard에 대해서만 입력함
        Product[] burgers = new Product[5];
        burgers[0] = new Product("ShackBurger", "토마토, 양상추, 쉑소스 버거", 6.9);
        burgers[1] = new Product("SmokeShack", "베이컨, 체리 페퍼, 쉑소스 버거", 8.9);
        burgers[2] = new Product("Shroom Burger", "몬스터 치즈, 체다 치즈 버거", 9.4);
        burgers[3] = new Product("CheeseBurger", "포테이토 번, 비프패티, 치즈 버거", 6.9);
        burgers[4] = new Product("Hamburger", "비프패티, 야채 버거", 5.4);

        Product[] custards = new Product[3];
        custards[0] = new Product("Strawberry Custard", "딸기맛", 5.5);
        custards[1] = new Product("Cherry Custard", "체리맛", 6.6);
        custards[2] = new Product("Blueberry Custard", "블루베리맛", 7.7);

        Menu[] menuArray = new Menu[4];
        menuArray[0] = new Menu("Burgers", "앵거스 비프 버거", burgers);
        menuArray[1] = new Menu("Frozen Custard", "매장에서 만드는 아이스크림", custards);
        menuArray[2] = new Menu("Drinks", "매장에서 직접 만드는 음료");
        menuArray[3] = new Menu("Beer", "뉴욕 브루클린 맥주");

        // 1. 메인 메뉴판 화면
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuArray.length; i++) {
            System.out.printf("%d. %-20s | %s\n", i + 1, menuArray[i].name, menuArray[i].desc);
        }
        System.out.println("\n[ ORDER MENU ]");
        System.out.printf("%d. %-20s | %s", menuArray.length + 1, "Order", "장바구니를 확인 후 주문합니다.\n");
        System.out.printf("%d. %-20s | %s", menuArray.length + 2, "Cancel", "진행중인 주문을 취소합니다.\n\n");

        int n1 = sc.nextInt() - 1;

        // 2. 상품 메뉴판 화면
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n");
        System.out.printf("[ %s MENU ]\n", menuArray[n1].name);

        for (int i = 0; i < menuArray[n1].prods.length; i++) {
//            System.out.printf("%d. %-15s | W %4.2f | %s\n"
//                    , i+1, menuArray[0].prods[i].name, menuArray[0].prods[i].price, menuArray[0].prods[i].desc);
            Product p = menuArray[n1].prods[i];
            System.out.printf("%d. %-20s | W %4.2f | %s\n", i + 1, p.name, p.price, p.desc);
        }

        int n2 = sc.nextInt() - 1;
        
        // 3. 구매 화면
    }
}