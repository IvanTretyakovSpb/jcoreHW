package homework.sem03;

import java.time.LocalDate;

public class Manager extends Worker {

    public Manager(String surname, String name, String middleName, String position, String phoneNumber,
                   int salary, LocalDate birthDate) {
        super(surname, name, middleName, position, phoneNumber, salary, birthDate);
    }

    public Manager(String surname, String name, String middleName) {
        super(surname, name, middleName);
    }

    /**
     * Производит повышение заработной платы всем работникам, имеющим возраст более заданного.
     * Руководителям увеличение заработной платы не происходит.
     *
     * @param workers   массив работников для возможного повышения заработной платы
     * @param age       возраст, начиная с которого производится увеличение заработной платы
     * @param addAmount размер увеличения зарплаты
     */
    public static void addSalary(Worker[] workers, int age, int addAmount) {
        for (Worker worker : workers) {

            // Делаем дополнительную проверку на принадлежность работника к классу руководителя
            if (!(worker instanceof Manager) && worker.getAge() >= age) {
                worker.setSalary(worker.getSalary() + addAmount);
            }
        }
        System.out.printf("Зарплата повышена всем работникам старше %d лет, кроме руководителей!\n", age);
    }

    /**
     * Перегруженный метод для назначения руководителем задачи работнику
     *
     * @param task назначаемая работнику задача.
     * @param worker работник, который назначается исполнителем конкретной задачи.
     */
    public void assignTask(Task task, Worker worker) {

        // Руководитель назначает конкретному работнику конкретную задачу
        worker.assignTask(task);
    }
}