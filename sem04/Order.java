package homework.sem04;

final class Order {
    // Константы для указания текущих размеров скидок на праздники
    private static final double GENDER_DISCOUNT = 0.15;
    private static final double NEW_YEAR_DISCOUNT = 0.2;
    // Добавлен статический счётчик для присвоения уникальных идентификаторов заказам
    private static int countID = 0;
    private final int ID;
    private Customer customer;
    private Product product;
    private int amount;
    private Celebration date;

    public Order(Customer customer, Product product, int amount, Celebration date) {
        this.ID = ++countID;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order {ID=" + ID + " customer=" + customer.getName() + ", " + product +
                ", amount=" + amount + ", date=" + date.getHoliday() + '}';
    }

    public double getTotalCost() {
        if (date == Celebration.NEW_YEAR) {
            return amount * (1 - NEW_YEAR_DISCOUNT) * product.getPrice();
        }
        if (date == Celebration.MARCH_8 && customer.getGender() == Gender.FEMALE ||
                date == Celebration.FEBRUARY_23 && customer.getGender() == Gender.MALE) {
            return amount * (1 - GENDER_DISCOUNT) * product.getPrice();
        }
        return amount * product.getPrice();
    }
}
