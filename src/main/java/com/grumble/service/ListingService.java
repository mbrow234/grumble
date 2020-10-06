package com.grumble.service;

import com.grumble.dto.ListingDto;

import java.util.List;

public interface ListingService {

    ListingDto getListingById(Long id);
    List<ListingDto> getAllListings();
    Long deleteListingById(Long id);
    ListingDto createListing(ListingDto listingDto);

}
