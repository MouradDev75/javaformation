package fr.dawan.designspatterns.comportement.mediator2;

public class UserChat extends Participant{

    public UserChat(IChatRoom chatRoom, String id, String name) {
        super(chatRoom, id, name);
    }

    @Override
    public void send(String msg, String userId) {
        System.out.println(getName()+">>> Send Message: "+msg);
        getChatRoom().sendMessage(msg, userId);
    }

    @Override
    public void receive(String msg) {
        System.out.println(getName()+">>> Received Message: "+msg);
    }
}
