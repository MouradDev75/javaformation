package fr.dawan.apistream;

public class People {
    private String name;
    private int age;
    private Sexe sexe;

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

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public People(String name, int age, Sexe sexe) {
        this.name = name;
        this.age = age;
        this.sexe = sexe;
    }

    public People() {
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sexe=" + sexe +
                '}';
    }
}
