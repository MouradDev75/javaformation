package fr.dawan.javafunctional;

/*
Interface est une pseudo classe abstraite qui ne contient que des méthodes abstraites
 */

@FunctionalInterface
public interface ICalcul {

    int add(int x, int y);
    //void print();
    default void MethodeDefault() {}; //peut ^étre redéfinie par les classes filles
    static void MethodeStatic() {};
}
