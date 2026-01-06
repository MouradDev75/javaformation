package fr.dawan.solid.singleresponsability.bad;

public class Employe {

    private int id;
    private String name;
    private String adresse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Employe(int id, String name, String adresse) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
    }

    public Employe() {
    }

    public void save(Employe e){
        //logic
    }

    public boolean isPromotionDueThisYear(){
        //logic
        return false;
    }
}
/*
Single Of Responsability: une classe ne doit gérer qu'une seule et unique tâche
Si vous constatez que 2 tâches différentes ou plus sont gérées dans une classe, posez la question
de savoir si vous devez scinder la classe en 2 ou plusieurs classes

Ce principe s'applique: aux packages, classes et méthodes
Intérêts:
- Organisation du code
- Faible couplage
- Facile facile à maintenir
 */

/*
Constat: Employe est une classe qui gère plusieurs tâches: violation du Single Of Responsability
 */
