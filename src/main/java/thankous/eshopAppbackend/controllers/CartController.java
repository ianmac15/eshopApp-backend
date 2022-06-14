package thankous.eshopAppbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thankous.eshopAppbackend.models.Cart;
import thankous.eshopAppbackend.services.CartServiceImpl;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/carts")
public class CartController {

    private CartServiceImpl cartService;

    @Autowired
    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable(value = "id") long id) {
        return cartService.getCartById(id);
    }

    @PostMapping
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.saveCart(cart);
    }

    @PutMapping("/{id}")
    public Cart updateCart(@RequestBody Cart cart, @PathVariable(value = "id") long id) {
        return cartService.updateCart(id, cart);
    }

    @DeleteMapping
    public void deleteAllCarts() {
        cartService.deleteAllCarts();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCartById(@PathVariable(value = "id") long id) {
        cartService.deleteCartById(id);
    }
}
