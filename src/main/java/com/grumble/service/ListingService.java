package com.grumble.service;

import com.grumble.mapper.ListingMapper;
import com.grumble.model.Listing;
import com.grumble.repository.ListingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<com.grumble.entities.Listing> listingEntity = listingRepository.findById(id);

        Listing listing;
        if (listingEntity.isPresent()) {
            listing = listingMapper.mapEntityToListing(listingEntity.get());
        } else {
            return null;
        }

        return listing;
    }

    public Long deleteListingById(Long id) {

        try {
            listingRepository.deleteById(id);
        } catch (Exception e) {
            return null;
        }

        return id;
    }

    public Listing createListing(Listing listing) {
        return listingMapper.mapEntityToListing(listingRepository.save(listingMapper.mapListingToEntity(listing)));
    }

}
