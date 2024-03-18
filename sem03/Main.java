package homework.sem03;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Worker[] workers = {
                new Worker("Ivanov", "Ivan", "Ivanovich",
                        "developer", "+7-999-888-77-66", 1000,
                        LocalDate.of(1940, 10, 17)),
                new Worker("Petrov", "Alexandr", "Pavlovich", "guard",
                        "+7-999-111-22-33", 800,
                        LocalDate.of(1969, 11, 17)),
                new Worker("Orlov", "Mikhail", "Vladimirovich", "seller",
                        "+7-911-444-55-44", 700,
                        LocalDate.of(1980, 11, 17)),
                new Worker("Denisov", "Konstantin", "Sergeevich", "designer",
                        "+7-999-111-22-66", 2000,
                        LocalDate.of(1962, 11, 17)),
                new Worker("Danilov", "Oleg", "Igorevich", "developer",
                        "+7-922-123-78-81", 1500,
                        LocalDate.of(1970, 11, 17)),

                // Добавляем в массив работников одного менеджера
                new Manager("Titov", "Semen", "Andreevich", "top-manager",
                        "+7-911-911-91-19", 5000,
                        LocalDate.of(1965, 10, 10))
        };
        System.out.println("Исходный массив работников");
        System.out.println(Arrays.toString(workers));
        System.out.printf("Average age: %.2f\n", getAverageAge(workers));
        System.out.printf("Average salary: %.2f\n", getAverageSalary(workers));
        System.out.println("---".repeat(20));

        Manager.addSalary(workers, 45, 111);
        System.out.println("Массив работников после увеличения заработной платы");
        System.out.println(Arrays.toString(workers));
        System.out.println("---".repeat(20));

        List<Worker> workerList = Arrays.asList(workers);
        Collections.sort(workerList);
        System.out.println("Работники, отсортированные по возрасту");
        System.out.println(workerList);
        System.out.println("---".repeat(20));

        workerList.sort(new WorkerSalaryComparator());
        System.out.println("Работники, отсортированные по размеру заработной платы");
        System.out.println(workerList);
        System.out.println("---".repeat(20));

// Проверяем работу компаратора для сортировки работников по фамилии
        workerList.sort(new WorkerSurnameComparator());
        System.out.println("Работники, отсортированные по фамилии");
        System.out.println(workerList);
        System.out.println("---".repeat(20));

        // Проверяем работу методов по назначению задач как самими работниками, так и руководителем.
        workers[0].assignTask(new Task("Create connection web-app to MySQL database"));
        System.out.println("Работник " + workers[0] + "взял в работу задачу:");
        System.out.println(workers[0].getCurrentTask());
        // Создаём нового менеджера
        Manager topManager = new Manager("Popov", "Sergey", "Olegovich",
                "CEO", "+7-911-111-33-33", 7000,
                LocalDate.of(1970, 9, 25));
        topManager.assignTask(new Task("Fix the latest bug!"), workers[1]);
        System.out.println("Менеджер " + topManager + "назначил работнику " + workers[1] + "задачу:");
        System.out.println(workers[1].getCurrentTask());
    }

    public static double getAverageAge(Worker[] array) {
        int sumAge = 0;
        for (Worker worker : array) {
            sumAge += worker.getAge();
        }
        return sumAge / (double) array.length;
    }

    public static double getAverageSalary(Worker[] array) {
        int sumSalary = 0;
        for (Worker worker : array) {
            sumSalary += worker.getSalary();
        }
        return sumSalary / (double) array.length;
    }
}
