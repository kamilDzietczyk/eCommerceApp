package eCommerceApp.demo.Service;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Admin.Admin;
import eCommerceApp.demo.Model.Admin.AdminRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> findAll(){
     return adminRepository.findAll();
    }
    public Admin findById(Integer id) throws CreateException {
        Optional<Admin> adm = adminRepository.findById(id);
        if(adm.isEmpty()){
            throw new CreateException("Admin with id: "+id+"not found");
        }
        return adm.get();
    };
    public Admin save(Admin admin) throws CreateException {
        int ifExist = adminRepository.IfAdminExist(admin.getLogin());
        if(ifExist!=0){
            throw new CreateException("Admin with login: "+admin.getLogin()+"exist");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pwd = bCryptPasswordEncoder.encode(admin.getPassword());
        admin.setPassword(pwd);
        return adminRepository.save(admin);
    }

    public void deleteById(Integer id) throws CreateException {
        Optional<Admin> adm = adminRepository.findById(id);
        if(adm.isEmpty()){
            throw new CreateException("Admin with id: "+id+"not found");
        }
        adminRepository.deleteById(id);
    }

}
