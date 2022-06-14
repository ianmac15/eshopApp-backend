package thankous.eshopAppbackend.services;

import thankous.eshopAppbackend.models.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    Cart saveCart(Cart cart);
    Cart getCartById(long id);
    void deleteCartById(long id);
    void deleteAllCarts();
    Cart updateCart(long id, Cart cart);
}
