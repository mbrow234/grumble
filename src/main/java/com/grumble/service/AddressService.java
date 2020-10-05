package com.grumble.service;

import com.grumble.mapper.AddressMapper;
import com.grumble.model.Address;
import com.grumble.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public Address updateAddress(Address addressUpdated) {
        return addressMapper.mapEntityToAddress(addressRepository.save(addressMapper.mapAddressToEntity(addressUpdated)));
    }
}
