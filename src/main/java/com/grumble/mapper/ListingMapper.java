package com.grumble.mapper;

import com.grumble.entities.Listing;
import com.grumble.dto.ListingDto;

public interface ListingMapper {
    ListingDto mapEntityToListing(Listing listingEntity);
    Listing mapListingToEntity(ListingDto listingDto);
}
