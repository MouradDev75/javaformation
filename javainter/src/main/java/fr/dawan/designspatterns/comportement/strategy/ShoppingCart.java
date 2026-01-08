package fr.dawan.designspatterns.comportement.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item i){
        items.add(i);
    }

    public  void removeitem(Item i){
        items.remove(i);
    }

    public double calculateTotal(){
        double s = 0;
        for(Item i : items){
            s += i.getPrice();
        }
        return s;
    }

    /*
    Paiement:
    Option1: définir une méthode pour chaque moyen de paiement
    méthode de paiement par CB
    méthode de paiement par PayPal

    - Si nouveau mode de paiement à gérer -> ajout d'une nouvelle -> violation du open/close
    option2:
    Déléguer l'étape du paiement à une autre classe qui va définir une stratégie de paiement selon le mode
    choisi
     */

    public void pay(PaymentStrategy paymentStrategy){
        double amount = this.calculateTotal();
        paymentStrategy.pay(amount);
    }
}
