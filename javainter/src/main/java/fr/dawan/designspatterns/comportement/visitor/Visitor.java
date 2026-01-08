package fr.dawan.designspatterns.comportement.visitor;

/**
 * Interface qui décrit le rôle du pattern Visitor
 * Son rôle est de visiter des objets pour leur appliquer un traitement
 */
public interface Visitor {
    //void Visit(Rectangle rec);
    //void Visit(Cercle cercle);
    //void  Visit(Triangle t); //pour chauqe nouve objet - ajout d'une nouvelle méthode
    //Solution: méthode polymorphique par sous typage
    void  Visit(Forme t);
}
