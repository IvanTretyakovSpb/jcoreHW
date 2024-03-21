package homework.sem04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class InternetShop {
    final List<Customer> customers;
    final List<Product> products;
    final List<Order> orders;

    public InternetShop() {
        this.customers = Arrays.asList(
                new Customer("Tretyakov Ivan", 40, "+7-999-999-99-99", Gender.MALE),
                new Customer("Sokolova Victoria", 25, "+7-999-888-88-88", Gender.FEMALE),
                new Customer("Popov Oleg", 35, "+7-999-777-77-77", Gender.MALE),
                new Customer("Smirnova Olga", 29, "+7-999-555-55-55-55", Gender.FEMALE)
        );
        this.products = Arrays.asList(
                new Product("Book", 15),
                new Product("Pen", 10),
                new Product("Mobile phone", 300),
                new Product("Pencil", 5),
                new Product("Calculator", 20)
        );
        this.orders = new ArrayList<>(20);
    }

    Order makeOrder(Customer customer, Product product, int amount, Celebration date)
            throws CustomerException, ProductException, AmountException {
        if (!customers.contains(customer)) {
            throw new CustomerException(customer);
        }
        if (!products.contains(product)) {
            throw new ProductException(product);
        }
        if (amount < 1 || amount > 100) {
            throw new AmountException(amount);
        }
        return new Order(customer, product, amount, date);
    }
}
