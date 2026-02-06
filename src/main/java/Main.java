public class Main {
    public static void main(String[] args) {
        Product item1 = new Product(1, "Хлеб", 60);
        Product item2 = new Product(2, "Молоко", 100);
        Product item3 = new Product(3, "Майонез", 90);
        Product item4 = new Product(3, "Масло", 200);


        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.remove(3);
        repo.add(item4);
//        repo.remove(4);
    }
}
