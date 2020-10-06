package com.grumble.mapper;

import com.grumble.entities.Address;
import com.grumble.dto.AddressDto;

public interface AddressMapper {
    AddressDto mapEntityToAddress(Address addressEntity);
    Address mapAddressToEntity(AddressDto addressDto);
}
