package fr.dawan.designspatterns.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeDepartement implements Departement{

    //composite contient une liste d'objets imlémentant la mm méthode

    private List<Departement> departements = new ArrayList<>();

    public void addDepartement(Departement dep){
        departements.add(dep);
    }

    public void removeDepartement(Departement dep){
        departements.remove(dep);
    }

    @Override
    public void departementName() {
        departements.forEach(d -> d.departementName());
    }
}
