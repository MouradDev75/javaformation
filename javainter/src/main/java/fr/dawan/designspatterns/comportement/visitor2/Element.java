package fr.dawan.designspatterns.comportement.visitor2;

/**
 * Interface qui décrit qui le rôle de chaque objet dans le pattern Visitor.
 * Leur rôle est d'accepter la visite du visitor.
 */
public interface Element {
    void accept(Visitor v);
}
