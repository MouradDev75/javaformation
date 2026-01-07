package fr.dawan.architecturehexagonale.domain;

import fr.dawan.architecturehexagonale.domain.entities.Cart;
import fr.dawan.architecturehexagonale.domain.entities.Product;

public class CartService implements CartApi{

    private ProductSpi productSpi;
    private StockSpi stockSpi;
    private CartPersistence cartPersistence;

    public CartService(ProductSpi productSpi, StockSpi stockSpi, CartPersistence cartPersistence) {
        this.productSpi = productSpi;
        this.stockSpi = stockSpi;
        this.cartPersistence = cartPersistence;
    }

    @Override
    public Cart getCart(String cartId) {
        return cartPersistence.getCart(cartId);
    }

    @Override
    public Cart addproductTocart(String productRef, int quantityRequest, String cartId) {
        Product product = productSpi.retrieveProduct(productRef);
        int quantityAvailable = stockSpi.getProductAvailability(productRef);
        int quantityBought = Math.min(quantityAvailable, quantityRequest);

        Product productToAdd = product;
        productToAdd.setQuantityAvailable(quantityAvailable);
        productToAdd.setQuantityBought(quantityBought);

        Cart cart = cartPersistence.getCart(cartId);
        cart.getProducts().add(productToAdd);

        return cartPersistence.updateCart(cart);
    }
}
