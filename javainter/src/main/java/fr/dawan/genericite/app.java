package fr.dawan.genericite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class app {

    public static void main(String[] args) {
        /*
        Généricité: permet d'exprimer des méthodes et des classes (interfaces) identiques sur le plan
        algorithmiques mais différents sur la base des types.
        Avantages:
        - réutilisation du code
        - moins de cast -> moins de risques d'erreurs à l'exécution
         */

        Produit pr = new Produit(); //rôle du construteur est d'initialiser les attributs de l'objet id = 0 - name = null

        Calculate<String> c1 = new Calculate<>();
        c1.a = "a";
        c1.b = "b";

        Calculate<Integer> c2 = new Calculate<>();
        c2.a = 10;
        c2.b = 20;
        try {
            Rappel.divide(0);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            // fichier ou table de logs
        }

        System.out.println(">>> suite de l'application.......");

        List<Produit> prods = new ArrayList<>();
        prods.add(new Produit(1, "PC Dell"));
        prods.add(new Produit(2, "Ecran HP"));

        System.out.println(">>>>> Export BIN:");
        SerialTool.exportBin(prods, "produits.bin");

        for(Produit p : SerialTool.importBin("produits.bin")){
            System.out.println(p);
        }

        List<User> users = new ArrayList<>();
        users.add(new User(1, "Dawan"));
        users.add(new User(2, "Jehann"));

        SerialToolGeneric.exportBinGeneric(users, "users.bin");
        for(Serializable u : SerialToolGeneric.importBinGeneric("users.bin")){
            System.out.println(u);
        }

        System.out.println(">>>> Sérialisation CSV:");
        SerialTool.exportCsv(prods, "produits.csv",",");

        for(Produit p : SerialTool.importCsv("produits.csv", ",")){
            System.out.println(p);
        }
    }
}
