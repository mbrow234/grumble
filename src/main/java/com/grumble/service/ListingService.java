package com.grumble.service;

import com.grumble.common.AnimalType;
import com.grumble.common.ListingType;
import com.grumble.model.Address;
import com.grumble.model.Listing;
import com.grumble.model.User;
import com.grumble.model.builder.ListingBuilder;
import com.grumble.model.builder.PetAgeBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ListingService {

    //...

    public ListingService() {
        //...
    }

    public Listing getListingById(Long id) {
        //TODO: get listing from mysql database and return it
        //fake listing for now
        return new ListingBuilder()
                .withPetName("Zoey")
                .withAnimalType(AnimalType.DOG)
                .withPetAge(new PetAgeBuilder().withYears(2).withMonths(11).build())
                .withPrice(1000000.00)
                .withDaysOnGrumble(1)
                .withListingOwner(new User("Zoey", "Brown", "10-5-2020", new Address("11122 South 3452 West", "HappyVille", "84897", "UT", "USA")))
                .withListingType(ListingType.BREEDING_PARTNER)
                .build();
    }

    public Long deleteListingById(Long id) {
        //TODO: delete listing from mysql database and reutrn id of deleted listing

        return id;
    }

    public Listing createListing(Listing listing) {
        //TODO: save listing database
        return listing;
    }

}
