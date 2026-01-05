package fr.dawan.genericite;

/*
Possibilté d'ajouter des contraintes au type générique T: <T extends Product> - classes files de Product
                                                        : <T super Product> - classes supérieures à Product
                                                        : <T extends IRepository> - classes qui impémentent une interface
                                                        : <T extends Product & IRepository>
 */

public class Calculate<T> {

    public T a;
    public T b;

    public void permute(){
        T tmp = a;
        a = b;
        b = tmp;
    }
}
