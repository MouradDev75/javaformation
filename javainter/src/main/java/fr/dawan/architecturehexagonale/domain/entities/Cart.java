package fr.dawan.architecturehexagonale.domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String id;
    private List<Product> products = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Cart(String id) {
        this.id = id;
    }

    public Cart() {
    }

    public double totalCart(){
        double cartAmount = products.stream()
                .map(p -> p.getPrice() * p.getQuantityBought())
                .reduce(0.0, Double::sum);

        if(cartAmount > 100){
            cartAmount = cartAmount * 0.9;
        }
        return cartAmount;
    }
}
