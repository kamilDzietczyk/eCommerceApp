package eCommerceApp.demo.Service;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Cart.Cart;
import eCommerceApp.demo.Model.Cart.CartReposiroty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    CartReposiroty cartReposiroty;

    public CartService(CartReposiroty cartReposiroty) {
        this.cartReposiroty = cartReposiroty;
    }

    public List<Cart> findAll(){
        return cartReposiroty.findAll();
    }
    public Cart findAllById(Integer id) throws CreateException {
        Optional<Cart> cart = cartReposiroty.findById(id);
        if(cart.isEmpty()){
            throw new CreateException("Cart with id: "+id+" not found");
        }
        return cart.get();
    };
    public Cart save(Cart cart) throws CreateException {
        return cartReposiroty.save(cart);
    };
    public void deleteById(Integer id) throws CreateException {
        Optional<Cart> cart = cartReposiroty.findById(id);
        if(cart.isPresent()){
            throw new CreateException("Cart with id: "+id+" not found");
        }
        cartReposiroty.deleteById(id);
    };
}
