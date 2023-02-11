package eCommerceApp.demo.Model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    List<Client> findAll();
    Optional<Client> findById(Integer id);
    Integer IfUserExist(String name);
    Client save(Client u);
    void deleteById(Integer integer);
}
