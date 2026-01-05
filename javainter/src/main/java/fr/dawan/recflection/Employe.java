package fr.dawan.recflection;

public class Employe extends Object{

    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Employe(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Employe() {
        nom = "Dawan";
        prenom = "Jehann";
    }

    public void identite(){
        System.out.println("Nom: "+nom+" Prénom: "+prenom);
    }
}
