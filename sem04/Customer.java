package homework.sem04;

final class Customer {
    // Добавлен статический счётчик для присвоения идентификаторов покупателям
    private static int countID = 0;
    private final int ID;
    private String name;
    private int age;
    private String phone;
    private Gender gender;

    public Customer(String name, int age, String phone, Gender gender) {
        this.ID = ++countID;
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

    public Gender getGender() {
        return gender;
    }
}
