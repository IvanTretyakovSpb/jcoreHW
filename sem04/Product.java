package homework.sem04;

final class Product {
    // Добавлен статический счётчик для присвоения идентификаторов товарам
    private static int countID = 0;
    private final int ID;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.ID = ++countID;
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
