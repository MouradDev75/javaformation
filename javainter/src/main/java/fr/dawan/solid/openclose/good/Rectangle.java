package fr.dawan.solid.openclose.good;

public class Rectangle implements Forme{
    private double hauteur;
    private double largeur;

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public Rectangle(double hauteur, double largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public Rectangle() {
    }

    @Override
    public double calculSurface() {
        return this.hauteur * this.largeur;
    }
}
