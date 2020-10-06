package com.grumble.service.impl;

import com.grumble.mapper.AddressMapper;
import com.grumble.model.Address;
import com.grumble.repository.AddressRepository;
import com.grumble.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public Address updateAddress(Address addressUpdated) {
        return addressMapper.mapEntityToAddress(addressRepository.save(addressMapper.mapAddressToEntity(addressUpdated)));
    }
}
