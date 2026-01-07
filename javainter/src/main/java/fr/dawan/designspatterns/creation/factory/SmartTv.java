package fr.dawan.designspatterns.creation.factory;

public class SmartTv implements Computer{
    @Override
    public void compute() {
        System.out.println("Smart TV");
    }
}
