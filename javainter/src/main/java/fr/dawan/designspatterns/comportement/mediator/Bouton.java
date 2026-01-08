package fr.dawan.designspatterns.comportement.mediator;

public class Bouton {

    private Fonction fan;

    public void press(){
        if(fan.isOn()){
            fan.setOn(false);
        }else{
            fan.setOn(true);
        }
    }
}
