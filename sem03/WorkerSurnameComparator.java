package homework.sem03;

import java.util.Comparator;

/**
 * Класс для создания компаратора для сравнения работников по фамилии
 */
public class WorkerSurnameComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
