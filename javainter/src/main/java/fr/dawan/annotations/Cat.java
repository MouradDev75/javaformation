package fr.dawan.annotations;

@VeryImportant
public class Cat {

    @ReadField
    private String name;
    @ReadField
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

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    @RunImmediately(times = 3)
    public void meow(){
        System.out.println(">>> meow......");
    }

    public void eat(){
        System.out.println(">>> eat......");
    }
}
