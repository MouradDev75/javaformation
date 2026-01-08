package fr.dawan.designspatterns.comportement.observer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Produit implements Sujet<Double>{

    private int id;
    private String name;
    private double price;

    //gère une liste d'observer
    private List<Observer<Double>> observers = new ArrayList<>();

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notify(price);
    }

    public List<Observer<Double>> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer<Double>> observers) {
        this.observers = observers;
    }

    public Produit(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public void attach(Observer<Double> obs) {
        observers.add(obs);
    }

    @Override
    public void detach(Observer<Double> obs) {
        observers.remove(obs);
    }

    @Override
    public void notify(Double obj) {
        observers.forEach(o -> o.update(obj));
    }
}
