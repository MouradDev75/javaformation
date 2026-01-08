package fr.dawan.designspatterns.comportement.mediator2;

import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements IChatRoom{

    //doit connaitre tous les objets
    private Map<String, Participant> usersMap = new HashMap<>();

    @Override
    public void addUser(Participant user) {
        usersMap.put(user.getId(), user);
    }

    //Doit gérer toutes les interactions entre les différents objets

    @Override
    public void sendMessage(String msg, String userId) {
        Participant p = usersMap.get(userId);
        p.receive(msg);
    }



}
