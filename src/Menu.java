public class Menu {
    String name;
    String desc;
    Product[] prods;

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

    public static Menu[] initialize() {
        // 0. 데이터 초기화
        Product[] burgers = {
                new Product("ShackBurger", "토마토, 양상추, 쉑소스 버거", 6.9),
                new Product("SmokeShack", "베이컨, 체리 페퍼, 쉑소스 버거", 8.9),
                new Product("Shroom Burger", "몬스터 치즈, 체다 치즈 버거", 9.4),
                new Product("CheeseBurger", "포테이토 번, 비프패티, 치즈 버거", 6.9),
                new Product("Hamburger", "비프패티, 야채 버거", 5.4)
        };

        Product[] custards = {
                new Product("Strawberry Custard", "딸기맛", 5.5),
                new Product("Cherry Custard", "체리맛", 6.6),
                new Product("Blueberry Custard", "블루베리맛", 7.7)
        };

        Product[] drinks = {
                new Product("Pepsi", "펩시 콜라", 1.9),
                new Product("Sprite", "스프라이트", 1.8),
                new Product("Coca Cola", "코카 콜라", 1.9),
                new Product("Fanta", "환타 오렌지향", 1.6)
        };

        Product[] beer = {
                new Product("Guinness", "아일랜드산 흑맥주 기네스", 3.8),
                new Product("San Miguel", "필리핀의 대표 맥주 산 미겔", 3.3),
                new Product("Terra", " 하이트진로의 알코올 4.6도의 라거 맥주 테라", 2.8)
        };

        return new Menu[]{
                new Menu("Burgers", "앵거스 비프 버거", burgers),
                new Menu("Frozen Custard", "매장에서 만드는 아이스크림", custards),
                new Menu("Drinks", "매장에서 직접 만드는 음료", drinks),
                new Menu("Beer", "뉴욕 브루클린 맥주", beer)
        };
    }
}
