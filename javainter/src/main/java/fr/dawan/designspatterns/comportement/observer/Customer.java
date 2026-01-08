package fr.dawan.designspatterns.comportement.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements Observer<CompteBancaire>{
    private String name;

    @Override
    public void update(CompteBancaire cpt) {

        System.out.println("Votre solde est négatif, il est de: "+cpt.getSolde());
        System.out.println("Vous de devez régulariser votre situation");
        System.out.println("Voulez vous effectuer un dépôt? (oui/non)");
        Scanner sc = new Scanner(System.in);
        String reponse = sc.next();
        if(reponse.equalsIgnoreCase("oui")){
            System.out.println("Montant: ");
            double montant = sc.nextDouble();
            cpt.depot(montant);
            System.out.println("Votre solde est de: "+cpt.getSolde());
        }else{
            System.out.println("Attention, vous avez 48h pour régulariser votre situation....");
        }

    }
}
