package eCommerceApp.demo.Model.Address;

import eCommerceApp.demo.Model.Client.Client;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    List<Address> findAll();
    Optional<Address> findById(Integer id);
    Address save(Address u);
    void deleteById(Integer integer);
}
