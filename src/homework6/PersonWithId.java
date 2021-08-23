package homework6;

public class PersonWithId {
    private final int id;
    private final String name;
    private final int age;

    public PersonWithId(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
