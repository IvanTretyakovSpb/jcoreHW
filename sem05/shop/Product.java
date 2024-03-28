package homework.sem05.shop;

final class Product {
    // Добавлен статический счётчик для присвоения идентификаторов товарам
    static int countID;
    private final int ID;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.ID = ++countID;
        this.name = name;
        this.price = price;
    }

    public Product(int ID, String name, int price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
