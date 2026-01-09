package fr.dawan.designspatterns.structure.bridge;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
class Product{
    private int id;
    private String description;
}

public class SystemExtern1 {
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "PC Dell"));
        products.add(new Product(2, "Ecran HP"));
        return products;
    }
}
