package fr.dawan.designspatterns.comportement.mediator2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Participant {

    //tous les ojets dépendent du Mediator
    private IChatRoom chatRoom;

    private String id;
    private String name;

    public abstract void send(String msg, String userId);
    public abstract void receive(String msg);
}
