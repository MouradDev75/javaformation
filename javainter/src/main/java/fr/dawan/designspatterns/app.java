package fr.dawan.designspatterns;

import fr.dawan.designspatterns.creation.LoggingSingleton;
import fr.dawan.designspatterns.creation.Pdg;
import fr.dawan.designspatterns.creation.ProductLombok;
import fr.dawan.designspatterns.creation.User;

public class app {
    static Pdg pdg3 = null, pdg4 = null;

    public static void main(String[] args) throws InterruptedException {
        /*
        Besoins de la conception objets:
        - Encapsuler des données sans en empêcher l'accès
        - Limiter les dépendances en tre les objets: héritage - composition - association - relation
        - Concevoir des objets polyvalents, flexibes et réutilisabes (pratiquer le polymorphisme)

        Designs Patterns: ce sont des solutions standards mises en place par la communauté objet dans le but
        de résoudre des problèmes réccurents liés à la conception objets.

        Les patterns sont des solution intéressantes car elles respectent les bonnes pratiques

        3 types de patterns:
        - patterns de création: singleton, builder, factory, prototype, abstract factory, object pool
        problèmes liés à la création d'objets
        - patterns de comportement: chaine of responsability, observer, state, strategy; visitor, mediator, template method
        problèmes liés au comportement des objets
        - patterns de structure: adapter, proxy, bridge, decrator, composite
        problèmes liès à la structure des objets
         */

        System.out.println(">>>>>>>>>>< Patterns de création <<<<<<<<<<<<");

        System.out.println("___ Singleton");
        /*
        problème: comment garantir l'existance d'une seule et unique instance d'une classe donnée dans toute l'application
         */

        /*
        lazy Singleton: à la demande -> permet d'optimiser la mémoire
         */

        Pdg pdg1 = Pdg.getInstance("pdg1");
        Pdg pdg2 = Pdg.getInstance("pdg2");

        System.out.println("pdg1 = "+pdg1.getName());
        System.out.println("pdg2 = "+pdg2.getName());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                pdg3 = Pdg.getInstance("pdg3");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
           pdg4 = Pdg.getInstance("pdg4");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("pdg3 = "+pdg3.getName());
        System.out.println("pdg4 = "+pdg4.getName());

        /*
        Eager Singleton
         */
        LoggingSingleton myLogger = LoggingSingleton.getInstance();
        myLogger.info("info");

        System.out.println("____ Builder:");
        /*
        Builder: permet de construire des objets complèxes (avec bcp d'attributs) étape par étape
         */

        User u1 = User.builder("u1_nom","u1_prenom")
                .withAge(25)
                .build();

        /*
        Dépéndance Lombok:
        1- installer le plugin lombok dans IntelliJ
        2- Ajouter la dépendance lombk dans le pom.xml
        3- utiliser les annontations de lombok
        lien doc: https://projectlombok.org/features/
         */

        ProductLombok p1 = ProductLombok.builder()
                .id(1)
                .name("PC Dell")
                .build();
        System.out.println(p1);
    }
}
