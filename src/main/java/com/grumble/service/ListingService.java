package com.grumble.service;

import com.grumble.mapper.ListingMapper;
import com.grumble.model.Listing;
import com.grumble.repository.ListingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ListingService {

    private ListingRepository listingRepository;
    private ListingMapper listingMapper;

    @Autowired
    public ListingService(ListingRepository listingRepository, ListingMapper listingMapper) {
        this.listingRepository = listingRepository;
        this.listingMapper = listingMapper;
    }

    public Listing getListingById(Long id) {

        return new Listing();
    }

    public Long deleteListingById(Long id) {
        //TODO: delete listing from mysql database and reutrn id of deleted listing

        return id;
    }

    public Listing createListing(Listing listing) {
        return listingMapper.mapEntityToListing(listingRepository.save(listingMapper.mapListingToEntity(listing)));
    }

}
