package fr.dawan.designspatterns.comportement.visitor;

/**
 * Interface décrivant le traitement commun à l'ensemble des objets et leur rôle dans le pattern Visitor
 */
public interface Forme {
    //void exportXml();
    void accept(Visitor v);
}
