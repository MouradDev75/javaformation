package fr.dawan.designspatterns.comportement.observer;

public class CompteBancaire implements Sujet<CompteBancaire>{

    private String numero;
    private double solde;

    @Override
    public void attach(Observer<CompteBancaire> obs) {

    }

    @Override
    public void detach(Observer<CompteBancaire> obs) {

    }

    @Override
    public void notify(CompteBancaire obj) {

    }
}
