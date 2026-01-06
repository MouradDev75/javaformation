package fr.dawan.solid.liskovsubstitution.good;

public class TransportationDevicewithEngine extends TransportationDevice{
    private Engine engine;

    @Override
    public void startMoving() {
        engine.startEngine();
    }
}
