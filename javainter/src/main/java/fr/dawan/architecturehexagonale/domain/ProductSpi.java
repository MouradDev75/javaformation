package fr.dawan.architecturehexagonale.domain;

import fr.dawan.architecturehexagonale.domain.entities.Product;

public interface ProductSpi {
    Product retrieveProduct(String productRef);
}
