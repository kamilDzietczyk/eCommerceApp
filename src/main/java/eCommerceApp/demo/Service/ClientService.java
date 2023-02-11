package eCommerceApp.demo.Service;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Client.Client;
import eCommerceApp.demo.Model.Client.ClientRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Client findAllById(Integer id) throws CreateException {
        Optional<Client> cli = clientRepository.findById(id);
        if(cli.isEmpty()){
            throw new CreateException("Client with id: "+id+" not found");
        }
        return cli.get();
    };

    public Client save(Client c) throws CreateException {
        int ifExist = clientRepository.IfUserExist(c.getName());
        if(ifExist!=0){
            throw new CreateException("Client with id: "+c.getLogin()+" exist");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pwd = bCryptPasswordEncoder.encode(c.getPassword());
        c.setPassword(pwd);
        clientRepository.save(c);
        return c;
    };
    public void deleteById(Integer id) throws CreateException {
        Optional<Client> cli = clientRepository.findById(id);
        if(cli.isPresent()){
            throw new CreateException("Client with id: "+id+" not found");
        }
        clientRepository.deleteById(id);
    };
}
