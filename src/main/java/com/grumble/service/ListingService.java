package com.grumble.service;

import com.grumble.model.Listing;

public interface ListingService {

    Listing getListingById(Long id);
    Long deleteListingById(Long id);
    Listing createListing(Listing listing);

}
