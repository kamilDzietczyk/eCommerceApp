package eCommerceApp.demo.Adapter;

import eCommerceApp.demo.Model.ClientAddress.ClientAddress;
import eCommerceApp.demo.Model.ClientAddress.ClientAddressRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SQLClientAddressRepository extends ClientAddressRepository, JpaRepository<ClientAddress,Integer> {
}
