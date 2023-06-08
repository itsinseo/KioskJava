public class Main {
    public static void main(String[] args) {
        Menu[] menuArray = MenuInit.initialize();
        Order orders = new Order();
        Order sales = new Order();

        //키오스크는 무한 루프
        while (true) {
            //메인 메뉴, 입력 받고 각 메뉴로
            int n1 = Display.mainMenu(menuArray);

            if (n1 == menuArray.length + 1) {
                //주문 메뉴
                Display.order(orders, sales);
            } else if (n1 == menuArray.length + 2) {
                //취소 메뉴
                Display.cancel(orders);
            } else if (n1 == -1) {
                break;
            } else if (n1==0) {
                //총 판매 액수 & 목록
                Display.totalSales(sales);
                Display.totalList(sales);
            }
            else {
                //상품 메뉴
                int n2 = Display.productMenu(menuArray, n1 - 1);
                //구매(장바구니에 추가) 메뉴
                Display.addToCartMenu(menuArray[n1 - 1].getProds()[n2 - 1], orders);
            }
        }
    }
}