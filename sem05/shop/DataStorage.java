package homework.sem05.shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения массивов данных об объектах магазина во время его работы
 */
abstract class DataStorage {
    final static List<Customer> customers = new ArrayList<>();
    final static List<Product> products = new ArrayList<>();
    final static List<Order> orders = new ArrayList<>();
}
