package thankous.eshopAppbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thankous.eshopAppbackend.exceptions.ResourceNotFoundException;
import thankous.eshopAppbackend.models.Cart;
import thankous.eshopAppbackend.repositories.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> getAllCarts() {

        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isPresent()) {
            return optionalCart.get();
        }
        throw new ResourceNotFoundException("Cart with id: "+id+", doesn't exist!");
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteAllCarts() {
        cartRepository.deleteAll();
    }

    @Override
    public void deleteCartById(long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isPresent()) {
            cartRepository.deleteById(id);
        }
        throw new ResourceNotFoundException("Cart with id: "+id+", doesn't exist!");
    }

    @Override
    public Cart updateCart(long id, Cart oldCart) {
        Cart newCart = getCartById(id);
        newCart.setProducts(oldCart.getProducts());
        newCart.setName(oldCart.getName());
        return newCart;
    }
}
