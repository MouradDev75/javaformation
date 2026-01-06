package fr.dawan.encapsulation;

/*
Encapsulation:
l'accès aux attributs d'une classe (objet) passe forcément par les accésseurs (getter/setter)
Remplacer les get/set classiques par des méthodes métiers
 */
public class Rectangle {

    private double hauteur;
    private double largeur;

    private double getHauteur() {
        return hauteur;
    }

    private void setHauteur(double hauteur) throws Exception {
        if(hauteur < 0)
            throw new Exception("Hauteur doit être positive");
        this.hauteur = hauteur;
    }

    private double getLargeur() {

        return largeur;
    }

    private void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public void redim(double hauteur, double largeur) throws Exception {
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    public Rectangle(double hauteur, double largeur) throws Exception {
       setHauteur(hauteur);
        setLargeur(largeur);
    }

    public Rectangle() {
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "hauteur=" + hauteur +
                ", largeur=" + largeur +
                '}';
    }
}
