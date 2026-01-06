package fr.dawan.solid.liskovsubstitution.bad;

public class Car extends TransportationDevice{
    @Override
    public void startEngine() {
        //logic
        super.startEngine();
    }
}
