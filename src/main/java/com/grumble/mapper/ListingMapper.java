package com.grumble.mapper;

import com.grumble.model.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingMapper {

    private PetMapper petMapper;
    private UserMapper userMapper;

    @Autowired
    public ListingMapper(PetMapper petMapper, UserMapper userMapper) {
        this.petMapper = petMapper;
        this.userMapper = userMapper;
    }

    public Listing mapEntityToListing(com.grumble.entities.Listing listingEntity) {
        Listing listing = new Listing();

        listing.setId(listingEntity.getId());
        listing.setPrice(listingEntity.getPrice());
        listing.setListingType(listingEntity.getListingType());
        listing.setDaysOnGrumble(listingEntity.getDaysOnGrumble());
        listing.setPet(petMapper.mapEntityToPet(listingEntity.getPet()));
        listing.setListingOwner(userMapper.mapEntityToUser(listingEntity.getListingOwner()));

        return listing;
    }

    public com.grumble.entities.Listing mapListingToEntity(Listing listing) {
        com.grumble.entities.Listing listingEntity = new com.grumble.entities.Listing();

        listingEntity.setId(listing.getId());
        listingEntity.setPrice(listing.getPrice());
        listingEntity.setListingType(listing.getListingType());
        listingEntity.setDaysOnGrumble(listing.getDaysOnGrumble());
        listingEntity.setPet(petMapper.mapPetToEntity(listing.getPet()));
        listingEntity.setListingOwner(userMapper.mapUserToEntity(listing.getListingOwner()));

        return listingEntity;
    }

}
