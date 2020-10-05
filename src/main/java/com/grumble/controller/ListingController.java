package com.grumble.controller;

import com.grumble.model.Listing;
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
    public ResponseEntity<Listing> getListingById(@PathVariable Long id) {
        log.info("REST Resource called (listing) - getListingById: {}", id);

        Listing listing = listingService.getListingById(id);

        if (null == listing) {
            log.error("Failed to get listing by id: {}", id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(listing, HttpStatus.OK);
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
    public ResponseEntity<Listing> createListing(@RequestBody Listing listing) {
        log.info("REST Resource called (listing) - createListing");

        Listing retListing = listingService.createListing(listing);

        if (null == retListing) {
            log.error("Failed to create listing");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(retListing, HttpStatus.OK);
    }

}
