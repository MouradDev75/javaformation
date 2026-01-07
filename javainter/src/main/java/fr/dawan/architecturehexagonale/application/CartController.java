package fr.dawan.architecturehexagonale.application;

import fr.dawan.architecturehexagonale.application.dtos.CartDto;
import fr.dawan.architecturehexagonale.domain.CartApi;
import fr.dawan.architecturehexagonale.domain.entities.Cart;

public class CartController {
    private CartApi cartApi;

    public CartController(CartApi cartApi) {
        this.cartApi = cartApi;
    }

    public CartDto getCart(String cartId){
        Cart cart = cartApi.getCart(cartId);

        return convertCartToDto();
    }

    public CartDto addProductToCart(String productRef, int quantityRequest, String cartId){
        Cart cart = cartApi.addproductTocart(productRef, quantityRequest, cartId);
        return convertCartToDto();
    }

    private CartDto convertCartToDto() {
        return null;
    }
}
