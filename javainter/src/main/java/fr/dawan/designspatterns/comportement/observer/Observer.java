package fr.dawan.designspatterns.comportement.observer;

/**
 * Interface qui décrit le rôle de l'objet observer dans le pattern Observer
 * son rôle est de réagir à la notification transmise par e sujet
 * @param <T>
 */
public interface Observer<T> {
    void update(T obj);
}
