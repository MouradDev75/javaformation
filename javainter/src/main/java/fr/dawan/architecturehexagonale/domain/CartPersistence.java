package fr.dawan.architecturehexagonale.domain;

import fr.dawan.architecturehexagonale.domain.entities.Cart;

public interface CartPersistence {
    Cart getCart(String cartId);
    Cart updateCart(Cart Cart);
}
