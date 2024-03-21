package homework.sem04;

public class Application {
    public static void main(String[] args) {
        final InternetShop shop = new InternetShop();
        final Object[][] data = {
                // correct data for new order
                {shop.customers.get(0), shop.products.get(0), 5, Celebration.NOT_HOLIDAY},
                // correct data for female on March 8
                {shop.customers.get(1), shop.products.get(1), 10, Celebration.MARCH_8},
                // correct data for male on March 8
                {shop.customers.get(0), shop.products.get(1), 20, Celebration.MARCH_8},
                // correct data for male on March 8
                {shop.customers.get(2), shop.products.get(2), 4, Celebration.FEBRUARY_23},
                // correct data on Ney Year
                {shop.customers.get(3), shop.products.get(3), 10, Celebration.NEW_YEAR},
                // incorrect amount -7
                {shop.customers.get(1), shop.products.get(4), -7, Celebration.NOT_HOLIDAY},
                // incorrect amount 333
                {shop.customers.get(2), shop.products.get(1), 333, Celebration.NOT_HOLIDAY},
                // incorrect product
                {shop.customers.get(3), new Product("Car", 100_000), 2, Celebration.NOT_HOLIDAY},
                // incorrect customer
                {new Customer("Alex", 33, "+112", Gender.MALE), shop.products.get(2), 5,
                        Celebration.NOT_HOLIDAY}
        };

        double totalCostOrders = 0;
        for (Object[] obj : data) {
            try {
                Order newOrder = shop.makeOrder((Customer) obj[0], (Product) obj[1], (Integer) obj[2], (Celebration) obj[3]);
                shop.orders.add(newOrder);
                totalCostOrders += newOrder.getTotalCost();
                System.out.printf("Order was successfully saved.\n%s\nTotal cost: %.2f\n",
                        newOrder, newOrder.getTotalCost());
            } catch (AmountException e) {
                System.out.println(e.getMessage());
                Order changedOrder = new Order((Customer) obj[0], (Product) obj[1], 1, (Celebration) obj[3]);
                shop.orders.add(changedOrder);
                totalCostOrders += changedOrder.getTotalCost();
                System.out.printf("Order was created with a product quantity of 1.\n%s\nTotal cost: %.2f\n",
                        changedOrder, changedOrder.getTotalCost());
            } catch (ProductException e) {
                System.out.println(e.getMessage());
                System.out.println("Order cancelled!");
            } catch (CustomerException e) {
                System.out.println(e.getMessage());
                System.out.println("Application terminated incorrectly!");
            } finally {
                System.out.printf("Number of saved orders: %d. Total cost: %.2f\n", shop.orders.size(), totalCostOrders);
                System.out.println("-------------".repeat(10));
            }
        }
    }
}