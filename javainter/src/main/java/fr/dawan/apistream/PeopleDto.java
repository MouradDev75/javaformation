package fr.dawan.apistream;

public class PeopleDto {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PeopleDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PeopleDto() {
    }

    @Override
    public String toString() {
        return "PeopleDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
