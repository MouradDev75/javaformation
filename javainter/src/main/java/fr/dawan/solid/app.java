package fr.dawan.solid;

import fr.dawan.solid.dependecyinversion.good.ContactFichierRepo;
import fr.dawan.solid.dependecyinversion.good.ContactRepository;
import fr.dawan.solid.dependecyinversion.good.ContactService;
import fr.dawan.solid.liskovsubstitution.bad.Bicycle;
import fr.dawan.solid.liskovsubstitution.bad.Car;
import fr.dawan.solid.liskovsubstitution.bad.TransportationDevice;

public class app {
    public static void main(String[] args) {
        /*
        SOLID: est l'acronyme de 5 principes de base
        S: Single of reponsability principal
        O: Open/close principal
        L: Liskov Substitution Principal
        I: Intefacres Sergregation principal
        D: Dependency Inversion / Dependency Injection

        ce sont de bonnes pratiques à appliquer dans la conception objet.
        Avantages:
        permettent d'améliorer la cohésion, de diminuer le couplage et de favoriser l'encapsulation d'un objet

        Cohésion:
        Un module (classe ou objet) est cohésif lorsqu'il ne gère qu'une seule et unique tâche

        Couplage:
        le couplage est une métrique qui mesure l'interconnexion des modules (classes - objets)

        Encapsulation:
         Un objet (classe) devrait masquer au maximum sa structure interne

         */

        /*
        Single of responsability: une classe ne doit gérer qu'une seule et unique tâche
        Open/Close: classe ouverte à 'extension mais fermée à la modification
        Liskov Substitution (concerne l'héritage): Les objets enfants doivent être substituables
        aux objets parents.
        Remplacer un objet parent par un objet enfant ne doit pas le comportement du code.
        Si un objet A se comporte comme un Objet B, alors A hérite B
         */

        TransportationDevice parent = new TransportationDevice();
        parent.startEngine();

        parent = new Car();
        parent.startEngine();

        parent = new Bicycle();
        parent.startEngine(); //pas de moteur dans un vélo
        /*
        Bicycle ne se comporte pas comme l'objet parent: héritage invalide -> violation de liskov Substitution
        Bicycle ne peut pas hériter de la classe TransportationDevice
         */

        /*
        Interfaces Segregation: découpage d'interfaces complèxes en petites interfaces ne gérant
        qu'un seul besoin métier. Application du single Of Responsability dans les interfaces
         */

        /*
        D: Dependecy Inversion / Dependecy Injection
         */

        //option1: injection via constructeur
        ContactService contactService = new ContactService(new ContactRepository());
        contactService.computeContact(10);

        //pour changer de dépendance, on doit réinstancier ContactService
        contactService = new ContactService(new ContactFichierRepo());

        //Option2: injection via params de la méthode
        ContactService service2 = new ContactService();
        service2.computeContact(10, new ContactRepository());

        //possibilité de changer de dépendance
        service2.computeContact(5, new ContactFichierRepo());

        //Option3: injection via le setter
        ContactService service3 = new ContactService();
        service3.setRepo(new ContactRepository());
        service3.computeContact(5);

        service3.setRepo(new ContactFichierRepo()); //possibilité de changer de dépendance


    }
}
