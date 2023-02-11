package eCommerceApp.demo.Controler;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Address.Address;
import eCommerceApp.demo.Model.Client.Client;
import eCommerceApp.demo.Service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAll(){
        return addressService.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Address> getById(@PathVariable Integer id) throws CreateException {
        Address a = addressService.findAllById(id);
        return a != null ? ResponseEntity.ok(a) : new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/Add")
    public ResponseEntity<Address> saveClient(@RequestBody @Valid Address a) throws CreateException {
        Address adr = addressService.save(a);
        return adr != null ? ResponseEntity.ok(adr) : new ResponseEntity<Address>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> saveClient(@PathVariable Integer id, @RequestBody @Valid Address a) throws CreateException{
        if(addressService.findAllById(id) == null) {
            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }else{
            a.setId(id);
            Address adr = addressService.save(a);
            return ResponseEntity.ok(adr);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id) throws CreateException {
        addressService.deleteById(id);
        return ResponseEntity.ok("Person was deleted");
    }
}
