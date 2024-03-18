package homework.sem03;

import java.time.LocalDate;

public class Task {
    // Статическая переменная для счётчика всех задач
    private static int idCount = 0;
    private int id;
    private String title;
    private LocalDate deadline;
    private Worker executor;

    public Task(String title) {
        this.id = ++idCount;
        this.title = title;
        this.deadline = LocalDate.now().plusDays(2);
    }

    public Task(String title, LocalDate deadline) {
        this.id = ++idCount;
        this.title = title;
        this.deadline = deadline;
    }

    public Worker getExecutor() {
        return executor;
    }

    public void setExecutor(Worker executor) {
        this.executor = executor;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task: " +
                "id=" + id +
                ", title='" + title + '\'' +
                ", deadline=" + deadline +
                ", executor: " + executor.getSurname() + " " + executor.getName() + "\n";
    }
}
