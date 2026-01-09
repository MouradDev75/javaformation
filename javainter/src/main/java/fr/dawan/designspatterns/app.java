package fr.dawan.designspatterns;

import fr.dawan.designspatterns.comportement.chainofrepsonsability.*;
import fr.dawan.designspatterns.comportement.mediator2.ChatRoom;
import fr.dawan.designspatterns.comportement.mediator2.IChatRoom;
import fr.dawan.designspatterns.comportement.mediator2.Participant;
import fr.dawan.designspatterns.comportement.mediator2.UserChat;
import fr.dawan.designspatterns.comportement.observer.*;
import fr.dawan.designspatterns.comportement.state.Commande;
import fr.dawan.designspatterns.comportement.strategy.*;
import fr.dawan.designspatterns.comportement.templatemethode.Facebook;
import fr.dawan.designspatterns.comportement.templatemethode.NetworkTemplateMethod;
import fr.dawan.designspatterns.comportement.templatemethode.Twitter;
import fr.dawan.designspatterns.comportement.visitor.*;
import fr.dawan.designspatterns.creation.factory.ComputerFactory;
import fr.dawan.designspatterns.creation.factory.Laptop;
import fr.dawan.designspatterns.creation.factory.Phone;
import fr.dawan.designspatterns.creation.factory.SmartTv;
import fr.dawan.designspatterns.creation.prototype.Question;
import fr.dawan.designspatterns.creation.prototype.Reponse;
import fr.dawan.designspatterns.creation.singleton.LoggingSingleton;
import fr.dawan.designspatterns.creation.singleton.Pdg;
import fr.dawan.designspatterns.creation.builder.ProductLombok;
import fr.dawan.designspatterns.creation.builder.User;
import fr.dawan.designspatterns.structure.bridge.*;
import fr.dawan.designspatterns.structure.composite.CompositeDepartement;
import fr.dawan.designspatterns.structure.composite.Departement;
import fr.dawan.designspatterns.structure.composite.DepartementFinance;
import fr.dawan.designspatterns.structure.composite.DepartementVente;
import fr.dawan.designspatterns.structure.facade.FacadeHelper;
import fr.dawan.designspatterns.structure.facade.MySqlHelper;
import fr.dawan.designspatterns.structure.facade.OracleHelper;
import fr.dawan.designspatterns.structure.proxy.Internet;
import fr.dawan.designspatterns.structure.proxy.ProxyInternet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class app {
    static Pdg pdg3 = null, pdg4 = null;

    public static void main(String[] args) throws Exception {
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
        Dépendance Lombok:
        1- installer le plugin lombok dans IntelliJ
        2- Ajouter la dépendance lombok dans le pom.xml
        3- utiliser les annontations de lombok
        lien doc: https://projectlombok.org/features/
         */

        ProductLombok p1 = ProductLombok.builder()
                .id(1)
                .name("PC Dell")
                .build();
        System.out.println(p1);

        System.out.println("____ Factory:");
        /*
        A utiliser avec objets liés (classe mère + classes filles)
        Factory (une fabrique): classe qui va gérer le process de création d'objet.
         */
        ComputerFactory factory = new ComputerFactory();
        Laptop laptop = (Laptop) factory.getComputer(Laptop.class);
        Phone phone = (Phone) factory.getComputer(Phone.class);
        SmartTv smart = (SmartTv) factory.getComputer(SmartTv.class);

        /*
        Inconvénoient: sa compléxité de mise en place
        avant de l'implémenter, se poser la question de sa compléxité
         */

        System.out.println("____ Prototype:");
        /*
        Comment créer d'objets complèxes à partir d'objets existants sans rendre le code dépendant
        Objet A existant
        b.setAge(a.getAge())
         */

        //pour les types simples, la question ne se pose pas
        int x = 10;
        int y = x; // y est une copie de x

        Reponse rep1 = new Reponse("reponse1", true);

        //comment faire une copie de rep1 sans faire appelle aux getter/setter
        /*
        Reponse rep2 = new Reponse();
        rep2.setTexte(rep1.getTexte());
        rep2.setCorrect(rep1.isCorrect());
        si les get/set deviennent private -> code inutilisable

        solution: implémenter l'interface cloneable
         */

        Reponse rep2 = (Reponse) rep1.clone();

        rep1.setTexte("autre réponse");
        rep1.setCorrect(false);

        System.out.println(rep2.getTexte()); //reponse1
        System.out.println(rep2.isCorrect()); //true

        System.out.println(">>> Copie d'une question:");

        Question qst1 = new Question();
        qst1.setTexte("comment cloner une question?");
        qst1.getReponses().add(new Reponse("implémenter l'interface cloneable", true));
        qst1.getReponses().add(new Reponse("implémenter l'interface copy", false));

        Question qst2 = (Question) qst1.clone();

        qst1.setTexte("new texte");
        qst1.getReponses().get(0).setTexte("new réponse");

        System.out.println(qst2.getTexte());
        System.out.println(qst2.getReponses().get(0).getTexte());

        System.out.println(">>>>>>>>>>>>> Patterns de comportement");
        /*
        Très pratique dans une conception basée sur le métier (DDD: archi. hexagonale)
        permettent:
        - de décrire des algorithmes
        - de décrire des comportements entre les objets
        - de définir des formes de communications entre les objets
         */

        System.out.println("___ Chain of reponsability");
        /*
        Pour le mettre en place, il faut une hierarchie de classes avec un traitement que toutes les classes
        peuvent exécuter.
        Permet de faire circuler une demande dans une chaine d'objets, et chaque objet dans cette chaine
        peut soit traiter la demande soit la transmettre à l'objet supérieur
         */

        Teacher teacher = new Teacher("teacher", new ResponsablePedago("respo. padego.", new Directeur("directeur", null)));
        teacher.handleComplaint(new ComplaintRequest(125, 1, ComplaintState.OPEN,"req1"));
        teacher.handleComplaint(new ComplaintRequest(458, 2, ComplaintState.OPEN,"req2"));
        teacher.handleComplaint(new ComplaintRequest(785, 3, ComplaintState.OPEN,"req3"));

        System.out.println("___ Observer");
        /*
        Permet la mise en place d'un mécanisme de souscription pour envoyer des notifications
        à plusieurs objets au sujet d'evenements qu'ils observent
         */
        Produit prod = new Produit(1, "PC Dell", 1500);
        Observer<Double> obs1 = new Client("obs1");
        Observer<Double> obs2 = new Client("obs2");

        prod.attach(obs1);
        prod.attach(obs2);

        prod.setPrice(999); //ce changement de prix déclenche l'envoie de 2 notifs

        CompteBancaire cpt = new CompteBancaire("158sqdq", 1000);
        Customer customer = new Customer("cust");

        cpt.attach(customer);

        cpt.retrait(1900);

        System.out.println("___ Visitor");
        /*
        Pour le mettre en place il faut des objets qui partagent le mm traitement,
        mais qui diffère dselon le type de l'objet
        - Rôle du visitor est de visiter l'ensemble des objets pour leur appliquer un traitement
        - Rôle des différents objets est d'accèpter la visite du visitor

        Permet de séparer les traiatements et les objets sur lesquels ils opèrent.
        Permet de spécialiser les classes principales (les objets) en transferant les autres traitements
        dans une classe visitor

        Les classes objets ne nécessitent aucune modifications pour leur appliquer un nouveau traitement.
        Des objets ouverts à l'extension, mais fermés à la modification
         */

        List<Forme> formes = new ArrayList<>();
        formes.add(new Cercle());
        formes.add(new Rectangle());

        formes.forEach(f -> f.accept(new ExportXmlVisitor()));
        formes.forEach(f -> f.accept(new ExportJsonVisitor()));

        System.out.println("___ State");
        /*
        A utiliser si le comportement d'un objet varie selon son état.
        Concerne un objet qui peut avoir plusieurs états connus d'avance.
        Ex: Document: brouillant - en correction - publier
        Ex: Commande: validée - payée - livrée - reçue
         */

        Commande cmd = new Commande();
        cmd.printState();
        cmd.next();
        cmd.printState();
        cmd.next();
        cmd.printState();
        cmd.next();
        cmd.printState();
        cmd.next();
        cmd.printState();

        System.out.println("___ Mediator");
        /*
        Permet de réduire les dépendances entre les objets et de restreindre les communications directes
        entre les objets et de les forcer à collaborer via un objet intermédiaire appelé Madiator.
        Ex: piste d'attérissage: la tour de contrôle joue le rôle d'un médiateur entre les différents pilotes

        Le Mediator doit connaitre tous les objets et es interactions possibles entre ces objets.
        Tous les objets dépendent du Mediator
         */

        IChatRoom chatRoom = new ChatRoom();
        Participant participant1 = new UserChat(chatRoom,"1", "Marc");
        Participant participant2 = new UserChat(chatRoom,"2", "Marie");

        chatRoom.addUser(participant1);
        chatRoom.addUser(participant2);

        participant1.send("Hello", "2");
        participant2.send("Bonjour", "1");

        System.out.println("___ Strategy");
        /*
        Permet de définir une famille d'algorithmes, de les mettre dans des classes séparées
        et de rendre les objets interchangeables.

        Permet d'obtenir un code respectant la bonne pratique open/close

        Ex: appl. de déplacement GPS (itinéraire voiture, transports en communs, à pieds) génère un
        itinéraire selon le mode de déplacement choisie
        Ex: moyen de paiement pour les appli. d'achat en ligne
         */

        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("sdqsd", 150);
        Item item2 = new Item("dcfrty", 99);

        cart.addItem(item1);
        cart.addItem(item2);

        //paiement Cb
        cart.pay(new CarCreditStrategy("sqdqs","qsqd", "123", "15/12/2029"));

        //paiement PayPal
        cart.pay(new PaypalStrategy("email", "password"));

        //paiement par chèque
        cart.pay(new CheckStrategy("sdqsdqs1256"));

        System.out.println("___ Template Method");
        /*
        A mettre en place lorsque:
        des classes contient beaucoup de code similaire. Il s'agit du mm algorithme (les mm étapes), y'à que l'implémentation
        des étapes qui change d'une classe à une autre.

        template Method propose de mettre en place le squelette d'un algorithme dans une classe mère et de laisser les classes filles
        redéfinir certaines étapes de l'algorithme sans changer la structure du squelette définit dans la classe mère

        Template Method propose de découper un algorithme en plusieurs étapes, de transfomer étape en méthode, ensuite de regourper les appels de
        ces méthodes dans une seule méthode socle appelée Template Method.

        ex: réseaux sociaux: pour envoyer un message -> Etapes: login - send message - logout
        Beaucoup  de traitements similaires concernant les réseaux sociaux

         */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        NetworkTemplateMethod network = null;

        System.out.println("User name: ");
        String userName = reader.readLine();

        System.out.println("Password: ");
        String pwd = reader.readLine();

        System.out.println("Message: ");
        String msg = reader.readLine();

        System.out.println("""
                Choose social Network for posting message:
                1- Facebook
                2- Twitter
                """);
        int choice = Integer.parseInt(reader.readLine());
        if(choice == 1)
            network = new Facebook(userName, pwd);
        else
            network = new Twitter(userName, pwd);

        //Appelle de Template Method
        network.post(msg);

        reader.close();

        /*
        Sans le pattern Template Method
        network.login()
        network.sendMessage()
        network.logout()

         */
        System.out.println(">>>>>>>>>>>>>>>> patterns de structure:");
        /*
        Appelés aussi patterns de composition
        Pratiquent lors d'une conception basée sur l'interaction
         */

        System.out.println("___Proxy:");
        /*
        Permet de fournir un substitut d'un objet. Il donne le contrôle sur l'objet original vous
        permettant d'effectuer des traitements dessus avant ou apèrs que la demande ne lui parvienne.
        Dans un code, un proxy est une copie de l'objet original, les 2 objets partagent la mm structure
         */
        Internet internet = new ProxyInternet();
        internet.connectTo("dawan.fr");
        internet.connectTo("123.com");

        System.out.println("___Bridge:");
        /*
        permet de définir un pont entre l'appli. principale est les différents sys. externes
         */
        Bridge bridge = new ProduitBridge();
        List<ProduitEntity> entities1 = bridge.getProduitEntities(new SystemExtern1());
        List<ProduitEntity> entities2 = bridge.getProduitEntities(new SystemExtern2());

        System.out.println("___Composite:");
        /*
        Le pattern composite permet 2 choses:
        soit manipuler les objets individuellement
        soit manipuler une composition d'objet

        Prérecquis: les objets fournis par le système externe partagent la mm structure

         */
        //Option1: manipuler les objets individuellement
        Departement departementVente = new DepartementVente();
        Departement departementFinance = new DepartementFinance();
        departementFinance.departementName();
        departementVente.departementName();

        //Option2: manipuler une composition d'objets
        CompositeDepartement composite = new CompositeDepartement();
        composite.addDepartement(departementFinance);
        composite.addDepartement(departementVente);

        composite.departementName();

        System.out.println("___Facade:");
        /*
        Le plus répondu dans la pratique
        Propose un accès simplifié à un ensemble de classes complèxes.

        Ex: application qui appelle une BD distance (Oracle, MySql) et génère des rapports PDF et HTML
         */

        System.out.println(">> Sans Facade:");
        String tableName = "Employes";

        Connection cnx = OracleHelper.getOraclelConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOracleHtmlReport(tableName, cnx);
        oracleHelper.generateOraclePdfReport(tableName, cnx);

        Connection cnx2 = MySqlHelper.getMySqlConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHtmlReport(tableName, cnx2);
        mySqlHelper.generateMySqlPdfReport(tableName, cnx2);

        /*
        Facade propose en sortie des méthodes répondant aux besoins de l'application principale
         */
        System.out.println(">> Avec Facade:");
        FacadeHelper.generateReport(FacadeHelper.DbType.MYSQL, FacadeHelper.ReportType.HTML, tableName);
        FacadeHelper.generateReport(FacadeHelper.DbType.MYSQL, FacadeHelper.ReportType.PDF, tableName);
        FacadeHelper.generateReport(FacadeHelper.DbType.ORACLE, FacadeHelper.ReportType.HTML, tableName);
        FacadeHelper.generateReport(FacadeHelper.DbType.ORACLE, FacadeHelper.ReportType.PDF, tableName);


    }
}
