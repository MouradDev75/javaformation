package fr.dawan.dependances.relation;

/*
Dépendance de type relation: la plus faible forme de dépendance entre des objets
Limitée dans le temps => réduite à l'exécution de la méthodeB  - B utilise A de manière temporaire
 */
public class B {

    //pas d'attribut de type A (pas de composition ni association)
    public void methodeB(A a){
        a.methodeA();
    }
}
