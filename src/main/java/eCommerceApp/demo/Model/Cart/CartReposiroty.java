package eCommerceApp.demo.Model.Cart;

import eCommerceApp.demo.Model.Client.Client;

import java.util.List;
import java.util.Optional;

public interface CartReposiroty {
    List<Cart> findAll();
    Optional<Cart> findById(Integer id);
    Cart save(Cart c);
    void deleteById(Integer integer);
}
