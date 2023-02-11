package eCommerceApp.demo.Service;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Address.Address;
import eCommerceApp.demo.Model.ClientAddress.ClientAddress;
import eCommerceApp.demo.Model.ClientAddress.ClientAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientAddressService {
    ClientAddressRepository clientAddressRepository;

    public ClientAddressService(ClientAddressRepository clientAddressRepository) {
        this.clientAddressRepository = clientAddressRepository;
    }

    public List<ClientAddress> findAll(){
        return clientAddressRepository.findAll();
    }
    public ClientAddress findAllById(Integer id) throws CreateException {
        Optional<ClientAddress> cla = clientAddressRepository.findById(id);
        if(cla.isEmpty()){
            throw new CreateException("Address with id: "+id+" not found");
        }
        return cla.get();
    };

    public ClientAddress save(ClientAddress cla){
        return clientAddressRepository.save(cla);
    };
    public void deleteById(Integer id) throws CreateException {
        Optional<ClientAddress> cli = clientAddressRepository.findById(id);
        if(cli.isPresent()){
            throw new CreateException("Address with id: "+id+" not found");
        }
        clientAddressRepository.deleteById(id);
    };
}
