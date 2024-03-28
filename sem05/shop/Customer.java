package homework.sem05.shop;

final class Customer {
    // Добавлен статический счётчик для присвоения идентификаторов покупателям
    static int countID;
    private final int ID;
    private String name;
    private int age;
    private String phone;
    // Добавлено поле для хранения пола покупателя
    private Gender gender;

    public Customer(String name, int age, String phone, Gender gender) {
        this.ID = ++countID;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    public Customer(int ID, String name, int age, String phone, Gender gender) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer: " + "ID = " + ID + ", " + name + ", age " + age +
                ", phone " + phone + ", gender " + gender.getGender();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender == Gender.MALE ? "m" : "f";
    }
}
