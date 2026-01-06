package fr.dawan.solid.dependecyinversion.bad;

public class ContactService {

    public Object computeContact(int id){
        ContactRepository repo = new ContactRepository();
        Contact contact = repo.getById(id);
        //appliquer un traitement au contact et renvoyer un résultat

        return null;
    }
    /*
    code sans dépendance
    méthode complètement dépendante de ContactRepository: en cas de changement de repo
    la méthode nécessite des modifs
     */
}
