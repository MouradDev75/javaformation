package fr.dawan.designspatterns.structure.proxy;

import java.util.Arrays;
import java.util.List;

/**
 * Classe qui implémente le pattern proxy
 */
public class ProxyInternet implements Internet{

    //un proxy manipule l'objet original
    private Internet internet = new RealInternet();

    private static List<String> bannedSites = Arrays.asList("abc.com","123.com","azerty.com");

    @Override
    public void connectTo(String url) throws Exception {
        if(bannedSites.contains(url)){
            throw new Exception(url+ " access denied........");
        }
        internet.connectTo(url);
    }
}
