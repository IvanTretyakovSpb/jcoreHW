package homework.sem05.shop;

/**
 * Основной класс для запуска приложения, в котором создаётся экземпляр класса интернет-магазина.
 * Через магазин пропускается всевозможный набор данных для оформления заказов с учётом скидок и вызова исключений.
 */

public class Application {
    public static void main(String[] args) {

        // создаём экземпляр магазина
        final InternetShop shop = new InternetShop();

        // подготавливаем набор тестовых данных для создания заказов в магазине
        // (из списков, которые загружены из внешних файлов)
        final Object[][] data = {
                // correct data for new order
                {DataStorage.customers.get(0), DataStorage.products.get(0), 5, Celebration.NONE},
                // correct data for female on March 8
                {DataStorage.customers.get(1), DataStorage.products.get(1), 10, Celebration.MARCH_8},
                // correct data for male on March 8
                {DataStorage.customers.get(0), DataStorage.products.get(1), 20, Celebration.MARCH_8},
                // correct data for male on March 8
                {DataStorage.customers.get(2), DataStorage.products.get(2), 4, Celebration.FEB_23},
                // correct data on Ney Year
                {DataStorage.customers.get(3), DataStorage.products.get(3), 10, Celebration.NEW_YEAR},
                // incorrect amount -7
                {DataStorage.customers.get(1), DataStorage.products.get(4), -7, Celebration.NONE},
                // incorrect amount 333
                {DataStorage.customers.get(2), DataStorage.products.get(1), 333, Celebration.NONE},
                // incorrect product
                {DataStorage.customers.get(3), new Product("Car", 100_000), 2, Celebration.NONE}
        };

        // переменная для подсчёта общеё суммы сделанных заказов
        double totalCostOrders = 0;
        for (Object[] obj : data) {
            try {
                // на тестовых данных создаём новый заказ
                Order newOrder = shop.makeOrder((Customer) obj[0], (Product) obj[1],
                        (Integer) obj[2], (Celebration) obj[3]);
                // добавляем новый заказ в список магазина
                shop.addOrder(newOrder);
                // учитываем сумму заказа в общей стоимости заказов
                totalCostOrders += newOrder.getTotalCost();
                System.out.printf("Order was successfully saved.\nTotal cost: %.2f\n", newOrder.getTotalCost());
            } catch (ProductException e) {
                System.out.println(e.getMessage());
                System.out.println("Order cancelled!");
            } catch (AmountException e) {
                System.out.println(e.getMessage());
                // если количество товара указано не корректно, то проставляем в заказе 1
                Order changedOrder = new Order((Customer) obj[0], (Product) obj[1], 1, (Celebration) obj[3]);
                shop.addOrder(changedOrder);
                totalCostOrders += changedOrder.getTotalCost();
                System.out.printf("Order was created with a product quantity of 1.\nTotal cost: %.2f\n",
                        changedOrder.getTotalCost());
            } catch (CustomerException e) {
                System.out.println(e.getMessage());
                System.out.println("Application terminated incorrectly!");
            } finally {
                System.out.printf("Number of saved orders: %d. Total cost: %.2f\n",
                        DataStorage.orders.size(), totalCostOrders);
                System.out.println("-------------".repeat(10));
            }
        }

        // Добавляем в списки магазина по паре новых покупателей и товаров
        Customer vasiliy = new Customer("Vasiliy Bobrov", 21, "+7-234-432-11-99", Gender.MALE);
        shop.addCustomer(vasiliy);
        Customer mikhail = new Customer("Mikhail Vnukov", 51, "+7-326-147-18-55", Gender.MALE);
        shop.addCustomer(mikhail);

        Product chair = new Product("Black chair", 32);
        shop.addProduct(chair);
        Product table = new Product("White table", 54);
        shop.addProduct(table);

        // Перед завершением работы приложения сохраняем во внешние файлы все текущие данный об объектах магазина,
        // находящиеся в списках.
        shop.saveData();
    }
}