package com.grumble.controller;

import com.grumble.dto.AddressDto;
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
    public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto addressDtoUpdated) {
        log.info("REST Resource called - updateAddress");

        AddressDto addressDto = addressService.updateAddress(addressDtoUpdated);
        if (null == addressDto) {
            log.error("Failed to update addressDto.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

}
