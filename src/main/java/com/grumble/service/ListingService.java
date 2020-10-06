package com.grumble.service;

import com.grumble.dto.ListingDto;

public interface ListingService {

    ListingDto getListingById(Long id);
    Long deleteListingById(Long id);
    ListingDto createListing(ListingDto listingDto);

}
