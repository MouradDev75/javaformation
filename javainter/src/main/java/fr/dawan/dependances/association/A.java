package fr.dawan.dependances.association;

/*
Dépendance de type Association
A n'a pas besoin de connaitre le processus d'instanciation de B
 */
public class A {

    private B b;

    public A(B b){
        this.b = b;
    }
}
