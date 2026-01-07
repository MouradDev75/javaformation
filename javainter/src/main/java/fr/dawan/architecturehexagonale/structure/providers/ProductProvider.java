package fr.dawan.architecturehexagonale.structure.providers;

import fr.dawan.architecturehexagonale.domain.ProductSpi;
import fr.dawan.architecturehexagonale.domain.entities.Product;

public class ProductProvider implements ProductSpi {
    @Override
    public Product retrieveProduct(String productRef) {
        //logic
        return null;
    }
}
