import java.util.Scanner;

public class MainTest {
    static Menu[] menuArray = Menu.initialize();
    static Order orders = new Order();
    static int waitNum = 1;

    public static void main(String[] args) {
        //키오스크는 무한 루프
        while (true) {
            //메인 메뉴, 입력 받고 각 메뉴로
            int n1 = Display.mainMenu(menuArray);

            if (n1 == menuArray.length + 1) {
                //주문 메뉴
                int n3 = Display.order(orders);
                if (n3 == 1) {
                    //주문 완료
                    waitNum = Display.orderComplete(orders, waitNum);
                }
            } else if (n1 == menuArray.length + 2) {
                //취소 메뉴
                Display.cancel(orders);
            } else if (n1 == 0) {
                break;
            } else {
                //상품 메뉴
                int n2 = Display.productMenu(menuArray, n1 - 1);
                //구매(장바구니에 추가) 메뉴
                Display.addToCartMenu(menuArray[n1 - 1].prods[n2 - 1], orders);
            }
        }
    }
}