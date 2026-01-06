package fr.dawan.telldontask.good;

public class Compte {
    private int id;
    private double solde;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private double getSolde() {
        return solde;
    }

    private void setSolde(double solde) {
        this.solde = solde;
    }

    public Compte(int id, double solde) {
        this.id = id;
        this.solde = solde;
    }

    public Compte() {
    }

    public void retrait(double montant) throws Exception {
        if(solde < montant)
            throw new Exception("solde insuffisant....");
        solde -= montant;
    }
}
