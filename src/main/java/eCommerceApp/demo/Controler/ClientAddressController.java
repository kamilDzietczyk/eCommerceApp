package eCommerceApp.demo.Controler;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Client.Client;
import eCommerceApp.demo.Model.ClientAddress.ClientAddress;
import eCommerceApp.demo.Model.ClientAddress.ClientAddressRepository;
import eCommerceApp.demo.Service.ClientAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientAddress")
public class ClientAddressController {

    ClientAddressService clientAddressService;

    public ClientAddressController(ClientAddressService clientAddressService) {
        this.clientAddressService = clientAddressService;
    }

    @GetMapping
    public List<ClientAddress> getAll(){
        return clientAddressService.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientAddress> getById(@PathVariable Integer id) throws CreateException {
        ClientAddress ca = clientAddressService.findAllById(id);
        return ca != null ? ResponseEntity.ok(ca) : new ResponseEntity<ClientAddress>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/Add")
    public ResponseEntity<ClientAddress> saveClient(@RequestBody @Valid ClientAddress ca) throws CreateException {
        ClientAddress c = clientAddressService.save(ca);
        return c != null ? ResponseEntity.ok(c) : new ResponseEntity<ClientAddress>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientAddress> saveClient(@PathVariable Integer id, @RequestBody @Valid ClientAddress ca) throws CreateException{
        if(clientAddressService.findAllById(id) == null) {
            return new ResponseEntity<ClientAddress>(HttpStatus.NOT_FOUND);
        }else{
            ca.setId(id);
            return ResponseEntity.ok(clientAddressService.save(ca));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id) throws CreateException {
        clientAddressService.deleteById(id);
        return ResponseEntity.ok("Person was deleted");
    }
}
