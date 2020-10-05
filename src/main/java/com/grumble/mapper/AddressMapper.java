package com.grumble.mapper;

import com.grumble.model.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {

    public AddressMapper() {

    }

    public Address mapEntityToAddress(com.grumble.entities.Address addressEntity) {
        Address address = new Address();

        address.setId(addressEntity.getId());
        address.setStreetName(addressEntity.getStreetName());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setCountry(addressEntity.getCountry());
        address.setZipCode(addressEntity.getZipCode());

        return address;
    }

    public com.grumble.entities.Address mapAddressToEntity(Address address) {
        com.grumble.entities.Address addressEntity = new com.grumble.entities.Address();

        addressEntity.setId(address.getId());
        addressEntity.setStreetName(address.getStreetName());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setZipCode(address.getZipCode());
        addressEntity.setCountry(address.getCountry());

        return addressEntity;
    }

}
