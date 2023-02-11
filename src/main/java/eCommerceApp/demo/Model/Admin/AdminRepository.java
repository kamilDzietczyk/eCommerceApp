package eCommerceApp.demo.Model.Admin;


import java.util.List;
import java.util.Optional;

public interface AdminRepository {
    List<Admin> findAll();
    Optional<Admin> findById(Integer id);
    Admin findByLogin(String login);
    Integer IfAdminExist(String login);
    Admin save(Admin admin);
    void deleteById(Integer integer);
}
