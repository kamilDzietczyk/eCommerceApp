package eCommerceApp.demo.Controler;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Client.Client;
import eCommerceApp.demo.Service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientContrller {

    ClientService clientService;

    public ClientContrller(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAll(){
        return clientService.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Client> getById(@PathVariable Integer id) throws CreateException {
        Client c = clientService.findAllById(id);
        return c != null ? ResponseEntity.ok(c) : new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/Add")
    public ResponseEntity<Client> saveClient(@RequestBody @Valid Client c) throws CreateException {
        Client cli = clientService.save(c);
        return cli != null ? ResponseEntity.ok(cli) : new ResponseEntity<Client>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> saveClient(@PathVariable Integer id, @RequestBody @Valid Client c) throws CreateException{
        if(clientService.findAllById(id) == null) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }else{
            c.setId(id);
            Client cli = clientService.save(c);
            return ResponseEntity.ok(cli);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id) throws CreateException {
        clientService.deleteById(id);
        return ResponseEntity.ok("Person was deleted");
    }
}
