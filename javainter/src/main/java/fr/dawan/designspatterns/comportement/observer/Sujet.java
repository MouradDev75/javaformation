package fr.dawan.designspatterns.comportement.observer;

/**
Intervace qui décrit le rôle du sujet dans le pattern obsever
 Son rôle est de gérer une liste d'observer et d'envoyer des notifs si un son état change
 */
public interface Sujet<T> {
    void attach(Observer<T> obs);
    void detach(Observer<T> obs);
    void notify(T obj);
}
