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
}
