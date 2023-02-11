package eCommerceApp.demo.Adapter;

import eCommerceApp.demo.Model.Admin.Admin;
import eCommerceApp.demo.Model.Admin.AdminRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SQLAdminRepository extends AdminRepository, JpaRepository<Admin,Integer> {
    @Query("select count(a.login) from Admin a where a.login = ?1")
    Integer IfAdminExist(String login);
}
