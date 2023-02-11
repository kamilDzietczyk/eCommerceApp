package eCommerceApp.demo.Adapter;

import eCommerceApp.demo.Model.Address.Address;
import eCommerceApp.demo.Model.Address.AddressRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SQLAddressRepository extends AddressRepository, JpaRepository<Address,Integer> {
}
