package fr.dawan.dependances.heritage;

/*
Dépendance de type héritage: niveau de couplage le plus fort
Pb: tout changement dans la classe mère aura une incidence sur les classes filles
 */
public class B extends A{

    public B(int field) {
        super(field);
    }
}
