package fr.dawan.designspatterns.comportement.state;

import lombok.Data;

@Data
public class Commande {

    /*
    Etats de la commande:
    validée
    payée
    livrée
    reçue

    Solution1:

    if(etat == "validée")
            //comportement
    else if(etat == "payée")
            //comportement
    .........
    si un nouvel état de cet objet doit être pris en compte, cette classe nécessite des modifications
    => c'est une violation du open/close

    le pattern State propose de déléguer la gestion de chaque état à une autre qui va définir le comportement
    de l'objet

     */

    private CommandeState state = new CommandeValidee(); //état initial d'une commande


    public void next() {
        state.next(this);
    }


    public void previous() {
        state.previous(this);
    }


    public void printState() {
        state.printState();
    }
}
