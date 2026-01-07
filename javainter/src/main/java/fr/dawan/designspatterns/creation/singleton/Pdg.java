package fr.dawan.designspatterns.creation.singleton;

public class Pdg {

    private String name;
    /*
    Les attributs statiques ne sont instanciés qu'une seule fois
     */

    //2- définir un attribut static du type de a classe
    private static Pdg instance;

    public String getName() {
        return name;
    }

    //1- vérrouiller l'accès au constructeur par défaut
    private Pdg(){

    }

    /*
    Lazy: à la demande
    instance chargée en mémoire si cette méthode est appelée
     */
    //3- définir une méthode qui renvoie l'attribut static
    public static synchronized Pdg getInstance(String name){
        if(instance == null){
            instance = new Pdg();
        }
        instance.name = name;
        return instance;
    }
}
