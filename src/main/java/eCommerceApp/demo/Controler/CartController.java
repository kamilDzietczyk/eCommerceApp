package eCommerceApp.demo.Controler;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Address.Address;
import eCommerceApp.demo.Model.Cart.Cart;
import eCommerceApp.demo.Model.Cart.CartReposiroty;
import eCommerceApp.demo.Service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> getAll(){
        return cartService.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Cart> getById(@PathVariable Integer id) throws CreateException {
        Cart a = cartService.findAllById(id);
        return a != null ? ResponseEntity.ok(a) : new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/Add")
    public ResponseEntity<Cart> saveCart(@RequestBody @Valid Cart c) throws CreateException {
        Cart cart = cartService.save(c);
        return cart != null ? ResponseEntity.ok(cart) : new ResponseEntity<Cart>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Integer id, @RequestBody @Valid Cart c) throws CreateException{
        if(cartService.findAllById(id) == null) {
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }else{
            c.setId(id);
            Cart cart = cartService.save(c);
            return ResponseEntity.ok(cart);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable Integer id) throws CreateException {
        cartService.deleteById(id);
        return ResponseEntity.ok("Cart was deleted");
    }

}
