package fr.dawan.designspatterns.comportement.mediator;

import lombok.Data;



@Data
public class Fonction {

    private Bouton button;
    private Alimentation alimentation;
    private boolean isOn = false;

    public void turnOn(){
        alimentation.turnOn();
    }

    public void turnOf(){
        alimentation.turnOf();
    }

    public boolean isOn(){
        return isOn;
    }


}
