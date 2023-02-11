package eCommerceApp.demo.Controler;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Admin.Admin;
import eCommerceApp.demo.Service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAll(){
        return adminService.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Admin> getById(@PathVariable Integer id) throws CreateException {
        Admin a = adminService.findById(id);
        return a != null ? ResponseEntity.ok(a) : new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/Add")
    public ResponseEntity<Admin> saveAdmin(@RequestBody @Valid Admin a) throws CreateException {
        Admin adm = adminService.save(a);
        return adm != null ? ResponseEntity.ok(adm) : new ResponseEntity<Admin>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Integer id, @RequestBody @Valid Admin a) throws CreateException{
        if(adminService.findById(id) == null) {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }else{
            a.setId(id);
            Admin adm = adminService.save(a);
            return ResponseEntity.ok(adm);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Integer id) throws CreateException {
        adminService.deleteById(id);
        return ResponseEntity.ok("Admin was deleted");
    }
}
