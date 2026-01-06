package fr.dawan.polymorphisme;

import java.util.ArrayList;
import java.util.List;

public class app {

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Chat();
        Animal a3 = new Chien();
        /*
        Polymorphisme est une conséquence de l'héritage. C'est l'objet parent qui peut prendre la forme
        de tous les objets enfants
         */

        IPliable p1 = new Chaise();
        IPliable p2 = new Table();

        Object o = 10;
        Object o1 = "10";
        Object o2 = new Animal();

        //Collection polymorphique
        List<Animal> animaux = new ArrayList<>();
        animaux.add(new Animal());
        animaux.add(new Chat());
        animaux.add(new Chien());

        List<IPliable> pliables = new ArrayList<>();
        pliables.add(new Chaise());
        pliables.add(new Table());
        pliables.add(new Lit());

        acheter(new Chaise());
        acheter(new Table());
        acheter(new Lit());

        /*
        Polymorphisme: permet d'obtenir des applications facile à étendre
         */

        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        List<C> listC = new ArrayList<>();

        List<MyInterface> myListe = new ArrayList<>();
        myListe.add(new A());
        myListe.add(new B());
        myListe.add(new C());
        myListe.add(new D());

        methodePolymorphique(new A());
        methodePolymorphique(new B());
        methodePolymorphique(new C());
        methodePolymorphique(new D());
    }

    /*
    Polymorphisme par sous typage: le plus recommandé en pratique
     */
    public static void acheter(IPliable p){
        p.plier();
        p.deplier();
    }

    /*
    Poymorphisme ad-hoc: a éviter: nécessite un contrôle + un cast
     */
    public static void acheter2(Object o){
        if(o instanceof IPliable){
            IPliable p = (IPliable) o;
            p.plier();
            p.deplier();
        }
    }

    /*
    Poymorphisme par paramètre générique
     */
    public static <T extends IPliable> void acheter3(T o){
        o.plier();
        o.deplier();
    }

    public static void methodeA(A a){

    }
    public static void methodeB(B b){

    }
    public static void methodeC(C c){

    }

    public static void methodePolymorphique(MyInterface m){

    }


}
