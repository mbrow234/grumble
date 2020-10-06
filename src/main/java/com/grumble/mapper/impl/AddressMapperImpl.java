package com.grumble.mapper.impl;

import com.grumble.entities.Address;
import com.grumble.mapper.AddressMapper;
import com.grumble.dto.AddressDto;
import org.springframework.stereotype.Service;

@Service
public class AddressMapperImpl implements AddressMapper {

    public AddressMapperImpl() {

    }

    public AddressDto mapEntityToAddress(Address addressEntity) {
        AddressDto addressDto = new AddressDto();

        addressDto.setId(addressEntity.getId());
        addressDto.setStreetName(addressEntity.getStreetName());
        addressDto.setCity(addressEntity.getCity());
        addressDto.setState(addressEntity.getState());
        addressDto.setCountry(addressEntity.getCountry());
        addressDto.setZipCode(addressEntity.getZipCode());

        return addressDto;
    }

    public Address mapAddressToEntity(AddressDto addressDto) {
        Address addressEntity = new Address();

        addressEntity.setId(addressDto.getId());
        addressEntity.setStreetName(addressDto.getStreetName());
        addressEntity.setCity(addressDto.getCity());
        addressEntity.setState(addressDto.getState());
        addressEntity.setZipCode(addressDto.getZipCode());
        addressEntity.setCountry(addressDto.getCountry());

        return addressEntity;
    }

}
