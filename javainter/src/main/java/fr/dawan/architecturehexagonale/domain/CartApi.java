package fr.dawan.architecturehexagonale.domain;

import fr.dawan.architecturehexagonale.domain.entities.Cart;

public interface CartApi {
    Cart getCart(String cartId);
    Cart addproductTocart(String productRef, int quantityRequest, String cartId);
}
