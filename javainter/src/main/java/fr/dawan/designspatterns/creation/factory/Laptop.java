package fr.dawan.designspatterns.creation.factory;

public class Laptop implements Computer{
    @Override
    public void compute() {
        System.out.println("Laptop");
    }
}
