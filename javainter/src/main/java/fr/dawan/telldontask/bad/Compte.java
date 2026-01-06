package fr.dawan.telldontask.bad;

public class Compte {
    private int id;
    private double solde;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Compte(int id, double solde) {
        this.id = id;
        this.solde = solde;
    }

    public Compte() {
    }
}
