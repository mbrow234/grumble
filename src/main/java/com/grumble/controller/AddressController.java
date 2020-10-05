package com.grumble.controller;

import com.grumble.model.Address;
import com.grumble.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PutMapping("address")
    public ResponseEntity<Address> updateAddress(@RequestBody Address addressUpdated) {
        log.info("REST Resource called - updateAddress");

        Address address = addressService.updateAddress(addressUpdated);
        if (null == address) {
            log.error("Failed to update address.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
