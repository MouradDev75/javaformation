package fr.dawan.genericite;

import java.io.Serializable;

public class Produit implements Serializable {

    private int id;
    private String name;


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

    public Produit(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Produit() {
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
