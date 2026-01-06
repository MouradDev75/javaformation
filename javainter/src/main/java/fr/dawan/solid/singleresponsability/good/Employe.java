package fr.dawan.solid.singleresponsability.good;

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
}
