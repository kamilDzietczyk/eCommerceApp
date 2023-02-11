package eCommerceApp.demo.Adapter;

import eCommerceApp.demo.Model.Cart.Cart;
import eCommerceApp.demo.Model.Cart.CartReposiroty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SQLCartReposiroty extends CartReposiroty, JpaRepository<Cart,Integer> {
}
