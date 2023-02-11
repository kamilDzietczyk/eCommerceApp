package eCommerceApp.demo.Adapter;

import eCommerceApp.demo.Model.Client.Client;
import eCommerceApp.demo.Model.Client.ClientRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SQLClientRepository extends ClientRepository, JpaRepository<Client,Integer> {
    @Query("select count(c.name) from Client c where c.name = ?1")
    Integer IfUserExist(String emailAddress);
}
