package fr.dawan.solid.openclose.good;

public class Cercle implements Forme{
    private double rayon;

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    public Cercle() {
    }

    @Override
    public double calculSurface() {
        return Math.PI * Math.pow(this.rayon, 2);
    }
}
