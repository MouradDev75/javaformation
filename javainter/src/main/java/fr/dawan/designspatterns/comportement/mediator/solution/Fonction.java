package fr.dawan.designspatterns.comportement.mediator.solution;

import lombok.Data;

@Data
public class Fonction {

    private boolean isOn = false;

    private Mediator mediator;

    public void turnOn(){
        mediator.turnOn();
        isOn = true;
    }

    public void turnOf(){
        mediator.turnOf();
        isOn = false;
    }

    public boolean isOn(){
        return isOn;
    }
}
