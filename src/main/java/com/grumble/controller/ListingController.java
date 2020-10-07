package com.grumble.controller;

import com.grumble.dto.ListingDto;
import com.grumble.service.ListingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            log.warn("Failed to get listingDto by id: {}", id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(listingDto, HttpStatus.OK);
    }

    @GetMapping("listing")
    public ResponseEntity<List<ListingDto>> getAllListings() {
        log.info("REST Resource called - getAllListings");

        List<ListingDto> listingDtos = listingService.getAllListings();
        if (CollectionUtils.isEmpty(listingDtos)) {
            log.warn("Unable to find all listings.");
            return new ResponseEntity<>(listingDtos, HttpStatus.GONE);
        }

        return new ResponseEntity<>(listingDtos, HttpStatus.OK);
    }

    @DeleteMapping("listing/{id}")
    public ResponseEntity<Long> deleteListingById(@PathVariable Long id) {
        log.info("REST Resource called (listing) - deleteListingById: {}", id);

        Long listingId = listingService.deleteListingById(id);

        if (null == listingId) {
            log.warn("Unable to delete listing by id: {}", id);
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

    //TODO: implemnt PUT
}
