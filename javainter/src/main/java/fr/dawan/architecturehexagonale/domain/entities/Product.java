package fr.dawan.architecturehexagonale.domain.entities;

public class Product {

    private String ref;
    private String name;
    private double price;
    private int quantityAvailable;
    private int quantityBought;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    public Product(String ref, String name, double price, int quantityAvailable, int quantityBought) {
        this.ref = ref;
        this.name = name;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.quantityBought = quantityBought;
    }

    public Product() {
    }
}
