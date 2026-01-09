package fr.dawan.designspatterns.structure.proxy;

public class RealInternet implements Internet{
    @Override
    public void connectTo(String url) {
        System.out.println("connecting to: "+url);
    }
}
