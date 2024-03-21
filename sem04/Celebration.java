package homework.sem04;

/**
 * Перечисление для выбора праздника.
 * Имеет одно поле для хранения значения в удобном виде, конструктор и геттер для получения значения константы.
 */
public enum Celebration {
    NEW_YEAR("New Year"), MARCH_8("March 8"), FEBRUARY_23("February 23"),
    NOT_HOLIDAY("Ordinary day");
    private final String holiday;

    Celebration(String holiday) {
        this.holiday = holiday;
    }

    public String getHoliday() {
        return holiday;
    }
}