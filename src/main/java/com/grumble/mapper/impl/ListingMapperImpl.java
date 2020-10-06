package com.grumble.mapper.impl;

import com.grumble.entities.Listing;
import com.grumble.mapper.ListingMapper;
import com.grumble.mapper.PetMapper;
import com.grumble.mapper.UserMapper;
import com.grumble.dto.ListingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingMapperImpl implements ListingMapper {

    private PetMapper petMapper;
    private UserMapper userMapper;

    @Autowired
    public ListingMapperImpl(PetMapper petMapper, UserMapper userMapper) {
        this.petMapper = petMapper;
        this.userMapper = userMapper;
    }

    public ListingDto mapEntityToListing(Listing listingEntity) {
        ListingDto listingDto = new ListingDto();

        listingDto.setId(listingEntity.getId());
        listingDto.setPrice(listingEntity.getPrice());
        listingDto.setListingType(listingEntity.getListingType());
        listingDto.setDaysOnGrumble(listingEntity.getDaysOnGrumble());
        listingDto.setPetDto(petMapper.mapEntityToPet(listingEntity.getPet()));
        listingDto.setListingOwner(userMapper.mapEntityToUser(listingEntity.getListingOwner()));

        return listingDto;
    }

    public Listing mapListingToEntity(ListingDto listingDto) {
        Listing listingEntity = new Listing();

        listingEntity.setId(listingDto.getId());
        listingEntity.setPrice(listingDto.getPrice());
        listingEntity.setListingType(listingDto.getListingType());
        listingEntity.setDaysOnGrumble(listingDto.getDaysOnGrumble());
        listingEntity.setPet(petMapper.mapPetToEntity(listingDto.getPetDto()));
        listingEntity.setListingOwner(userMapper.mapUserToEntity(listingDto.getListingOwner()));

        return listingEntity;
    }

}
