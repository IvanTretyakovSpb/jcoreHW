package homework.sem04;

/**
 * Перечисление для выбора пола покупателя.
 * Имеет одно поле для хранения значения в удобном виде, конструктор и геттер для получения значения константы.
 */
enum Gender {
    MALE("male"), FEMALE("female");
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
