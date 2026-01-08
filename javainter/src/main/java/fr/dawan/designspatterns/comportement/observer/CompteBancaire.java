package fr.dawan.designspatterns.comportement.observer;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CompteBancaire implements Sujet<CompteBancaire>{

    private String numero;
    private double solde;

    private List<Observer<CompteBancaire>> observers = new ArrayList<>();

    public void depot(double montant){
        solde += montant;
    }

    public void retrait(double montant){
        solde -= montant;
        if(solde < 0)
            notify(new CompteBancaire(numero, solde));
    }

    public CompteBancaire(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    @Override
    public void attach(Observer<CompteBancaire> obs) {
        observers.add(obs);

    }

    @Override
    public void detach(Observer<CompteBancaire> obs) {
        observers.remove(obs);
    }

    @Override
    public void notify(CompteBancaire obj) {
        observers.forEach(o -> o.update(obj));
    }
}
