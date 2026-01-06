package fr.dawan.solid.openclose.bad;

public class Cercle {
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
}
