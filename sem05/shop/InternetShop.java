package homework.sem05.shop;

import java.io.*;
import java.util.Arrays;

/**
 * Класс, описывающий интернет-магазин. Хранит данные о покупателях, товарах и заказах.
 * Имеет метод для оформления нового заказа.
 */
final class InternetShop {
    // Данные о покупателях, товарах и заказах хранятся в ArrayList'х

    final File productsFile = new File("./src/homework/sem05/shop/products.txt");
    final File customerFile = new File("./src/homework/sem05/shop/customers.txt");
    final File ordersFile = new File("./src/homework/sem05/shop/orders.txt");

    private enum ObjectType {
        PRODUCT, CUSTOMER, ORDER;
    }

    // При создании экземпляра интернет-магазина он получает из файлов имеющийся на текущий момент
    // набор зарегистрированных покупателей, товаров и заказов, которые сохраняет в списки на время работы приложения
    public InternetShop() {
        // При создании экземпляра магазина производим выгрузку данных об объектах из внешних файлов
        readData(customerFile);
        readData(productsFile);
        readData(ordersFile);

        // Дополнительно устанавливаем актуальные значения в статические переменные для счётчиков
        // в классах соответствующих объектов магазина
        if (!DataStorage.customers.isEmpty()) Product.countID = DataStorage.products.getLast().getID();
        if (!DataStorage.products.isEmpty()) Customer.countID = DataStorage.customers.getLast().getID();
        if (!DataStorage.orders.isEmpty()) Order.countID = DataStorage.orders.getLast().getID();
    }

    /**
     * Создаёт экземпляр заказа и проверяет входящие данные на корректность.
     *
     * @param customer покупатель товара
     * @param product  покупаемый товар
     * @param amount   количество покупаемого товара
     * @param date     дата оформления заказа из набора перечислений для учёта наличия праздника
     * @return экземпляр заказа с валидными данными
     * @throws CustomerException фатальное исключение, завершающее работу приложения, в случае неучтенного покупателя
     * @throws ProductException  исключение при некорректном указании товара, заказ не оформляется
     * @throws AmountException   исключение при некорректном указании количества товара, заказ оформляется для количества 1.
     */
    Order makeOrder(Customer customer, Product product, int amount, Celebration date)
            throws CustomerException, ProductException, AmountException {
        if (!DataStorage.customers.contains(customer)) {
            throw new CustomerException(customer);
        }
        if (!DataStorage.products.contains(product)) {
            throw new ProductException(product);
        }
        if (amount < 1 || amount > 100) {
            throw new AmountException(amount);
        }
        return new Order(customer, product, amount, date);
    }

    /**
     * Считывает данные из указанного файла и записывает в соответствующего типа данных список магазина
     *
     * @param file имя файла для загрузки из него данных в магазин
     */
    void readData(File file) {
        switch (file.getName()) {
            case "products.txt" -> loadData(file, ObjectType.PRODUCT);
            case "customers.txt" -> loadData(file, ObjectType.CUSTOMER);
            case "orders.txt" -> loadData(file, ObjectType.ORDER);
            default -> System.out.println("Incorrect file name");
        }
    }

    /**
     * Выгружает данные из указанного файла в соответствующий по типу данных список магазина
     *
     * @param file имя файла для выгрузки данных
     * @param type тип данных, хранящихся в файле и списке магазина
     */
    void loadData(File file, ObjectType type) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] prod;
            String str;
            while ((str = br.readLine()) != null) {
                prod = str.split(",");
                switch (type) {
                    case PRODUCT -> DataStorage.products.add(new Product(Integer.parseInt(prod[0]),
                            prod[1], Integer.parseInt(prod[2])));
                    case CUSTOMER -> {
                        Customer customer = new Customer(Integer.parseInt(prod[0]), prod[1], Integer.parseInt(prod[2]),
                                prod[3], prod[4].equals("m") ? Gender.MALE : Gender.FEMALE);
                        DataStorage.customers.add(customer);
                    }
                    case ORDER -> DataStorage.orders.add(new Order(Integer.parseInt(prod[0]),
                            Integer.parseInt(prod[1]), Integer.parseInt(prod[2]), Integer.parseInt(prod[3])));
                    default -> System.out.println("Incorrect type");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Добавляет нового покупателя в список зарегистрированных в магазине
     *
     * @param customer добавляемый покупатель
     */
    void addCustomer(Customer customer) {
        DataStorage.customers.add(customer);
    }

    /**
     * Добавляет новый продукт в список доступных в магазине
     *
     * @param product добавляемый продукт
     */
    void addProduct(Product product) {
        DataStorage.products.add(product);
    }

    /**
     * Добавляет новый заказ в список заказов магазина
     *
     * @param order добавляемый заказ
     */
    void addOrder(Order order) {
        DataStorage.orders.add(order);
    }

    /**
     * Сохраняет все текущие данные об объектах магазина из его списков во внешние файлы
     */
    void saveData() {
        writeData(productsFile, ObjectType.PRODUCT);
        writeData(customerFile, ObjectType.CUSTOMER);
        writeData(ordersFile, ObjectType.ORDER);
    }

    /**
     * Записывает данные об объектах из конкретного списка магазина во внешний файл
     *
     * @param file имя внешнего файла для записи данных
     * @param type тип данных для записи
     */
    private void writeData(File file, ObjectType type) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            StringBuilder sb = new StringBuilder();
            switch (type) {
                case PRODUCT -> {
                    for (Product p : DataStorage.products) {
                        sb.append(p.getID()).append(",").append(p.getName()).append(",")
                                .append(p.getPrice()).append("\n");
                    }
                }
                case CUSTOMER -> {
                    for (Customer cst : DataStorage.customers) {
                        sb.append(cst.getID()).append(',').append(cst.getName()).append(',').append(cst.getAge())
                                .append(',').append(cst.getPhone()).append(',').append(cst.getGender()).append("\n");
                    }
                }
                case ORDER -> {
                    for (Order o : DataStorage.orders) {
                        sb.append(o.toString()).append("\n");
                    }
                }
                default -> System.out.println("Incorrect type");
            }
            bw.write(sb.toString());
            bw.flush();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
