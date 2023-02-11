package eCommerceApp.demo.Model.ClientAddress;

import eCommerceApp.demo.Model.Client.Client;

import java.util.List;
import java.util.Optional;

public interface ClientAddressRepository {
    List<ClientAddress> findAll();
    Optional<ClientAddress> findById(Integer id);
    ClientAddress save(ClientAddress cli);
    void deleteById(Integer integer);
}
