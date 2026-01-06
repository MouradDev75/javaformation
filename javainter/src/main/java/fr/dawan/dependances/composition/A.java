package fr.dawan.dependances.composition;

/*
Dépendance de type composition
- un type appartient à un autre
- Ajout de la responsabilité de création et de suppression
- nous impose de connaitre les étapes d'instanciation de l'objet interne B
 */
public class A {

    private B b;

    public A(){
        //A doit connaitre comment construre l'objet B
        this.b = new B("qsdqsd");
    }

    public void methodA(){
        if(b == null){
            b = new B("qdsqdqs");
        }
        b.methodB();
    }

}
