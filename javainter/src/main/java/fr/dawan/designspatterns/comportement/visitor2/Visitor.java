package fr.dawan.designspatterns.comportement.visitor2;

/**
 * Interface qui décrit le rôle du pattern Visitor
 * Visiter tout type d'objets et leur appliquer tout type de traitement
 * @param <T>
 * @param <R>
 */
public interface Visitor<T,R> {
    R visit(T obj);
}
