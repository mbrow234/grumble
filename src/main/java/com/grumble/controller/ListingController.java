package com.grumble.controller;

import com.grumble.dto.ListingDto;
import com.grumble.service.ListingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ListingController {
    private ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping("listing/{id}")
    public ResponseEntity<ListingDto> getListingById(@PathVariable Long id) {
        log.info("REST Resource called (listingDto) - getListingById: {}", id);

        ListingDto listingDto = listingService.getListingById(id);

        if (null == listingDto) {
            log.error("Failed to get listingDto by id: {}", id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(listingDto, HttpStatus.OK);
    }

    @DeleteMapping("listing/{id}")
    public ResponseEntity<Long> deleteListingById(@PathVariable Long id) {
        log.info("REST Resource called (listing) - deleteListingById: {}", id);

        Long listingId = listingService.deleteListingById(id);

        if (null == listingId) {
            log.error("Unable to delete listing by id: {}", id);
            return new ResponseEntity<>(id, HttpStatus.GONE);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("listing")
    public ResponseEntity<ListingDto> createListing(@RequestBody ListingDto listingDto) {
        log.info("REST Resource called (listingDto) - createListing");

        ListingDto retListingDto = listingService.createListing(listingDto);

        if (null == retListingDto) {
            log.error("Failed to create listingDto");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(retListingDto, HttpStatus.OK);
    }

}
