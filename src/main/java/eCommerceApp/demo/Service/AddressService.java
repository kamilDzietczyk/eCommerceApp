package eCommerceApp.demo.Service;

import eCommerceApp.demo.Exception.CreateException;
import eCommerceApp.demo.Model.Address.Address;
import eCommerceApp.demo.Model.Address.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }
    public Address findAllById(Integer id) throws CreateException {
        Optional<Address> add = addressRepository.findById(id);
        if(add.isEmpty()){
            throw new CreateException("Address with id: "+id+" not found");
        }
        return add.get();
    };

    public Address save(Address add){
        return addressRepository.save(add);
    };
    public void deleteById(Integer id) throws CreateException {
        Optional<Address> cli = addressRepository.findById(id);
        if(cli.isPresent()){
            throw new CreateException("Address with id: "+id+" not found");
        }
        addressRepository.deleteById(id);
    };
}
