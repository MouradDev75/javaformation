package fr.dawan.designspatterns.comportement.mediator2;

/**
 * Interface qui décrit le rôle du Mediator
 * Doit connaitre tous les objets et leur interactions
 */
public interface IChatRoom {

    void addUser(Participant user);
    void sendMessage(String msg, String userId);
}
