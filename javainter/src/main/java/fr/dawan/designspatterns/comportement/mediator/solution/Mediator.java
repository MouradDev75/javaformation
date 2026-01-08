package fr.dawan.designspatterns.comportement.mediator.solution;

/**
 * Classe qui décrit e rôle du pattern Mediator
 * 1- Doit connaitre tous les objets
 * 2- Doit connaitre toutes les interactions entre ces objet
 *
 */
public class Mediator {

    private Bouton bouton;
    private Alimentation alimentation;
    private Fonction fonction;

    //gestion du bouton
    public void press(){
      if(fonction.isOn()){
          fonction.setOn(false);
      }else{
          fonction.setOn(true);
      }
    }

    //gestion fonction
    public void turnOn(){
        alimentation.turnOn();
    }

    public void turnOf(){
        alimentation.turnOf();
    }
}
