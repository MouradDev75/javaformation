package fr.dawan.solid.dependecyinversion.good;



public class ContactService {

    //mise en evidence de la dépendance entre service et repository

    private IContactRepository repo;

    //option1: injection de dépendance via le constructeur
    /*
    Avantage: un objet ContactService est crée dans un état stable
    Inconvénient: impossible de changer de dépendance sans réinstancier la classe Service
     */


    public ContactService(IContactRepository repo) {
        this.repo = repo;
    }

    public Object computeContact(int id){

        Contact contact = repo.getById(id);
        //appliquer un traitement au contact et renvoyer un résultat

        return null;
    }

    //option2: injection de dépandance via les params de la méthode
    /*
    Avantage: possibilité de changer de dépendance
    Inconvénient: dépendance à fournir à chaque appelle de la méthode du service
     */


    public ContactService() {
    }

    public Object computeContact(int id, IContactRepository repo){
        this.repo = repo;
        Contact contact = repo.getById(id);
        //appliquer un traitement au contact et renvoyer un résultat

        return null;
    }

    //option3: injection de dépendance via le setter
    /*
    Avantage: possibilité de chager de dépendance
    Inconvénient - contrainte: il faut s'assurer que a dépendance à bien été injectée
     */

    public void setRepo(IContactRepository repo) {
        this.repo = repo;
    }
}
