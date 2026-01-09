package fr.dawan.designspatterns.structure.bridge;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
class Produit{
    private int prodId;
    private String name;
    private double price;
}

public class SystemExtern2 {

    public List<Produit> getProduits(){
        List<Produit> prods = new ArrayList<>();
        prods.add(new Produit(3, "Table", 450));
        prods.add(new Produit(45, "Chaise", 99));
        return prods;
    }
}
