package com.grumble.model.builder;

import com.grumble.common.ListingType;
import com.grumble.model.Listing;
import com.grumble.model.Pet;
import com.grumble.model.User;

public class ListingBuilder {

    private Pet pet;
    private double price;
    private User listingOwner;
    private int daysOnGrumble;
    private ListingType listingType;

    public ListingBuilder withPet(Pet pet) {
        this.pet = pet;
        return this;
    }

    public ListingBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ListingBuilder withListingOwner(User listingOwner) {
        this.listingOwner = listingOwner;
        return this;
    }

    public ListingBuilder withDaysOnGrumble(int daysOnGrumble) {
        this.daysOnGrumble = daysOnGrumble;
        return this;
    }

    public ListingBuilder withListingType(ListingType listingType) {
        this.listingType = listingType;
        return this;
    }

    public Listing build() {
        Listing listing = new Listing();

        listing.setPet(pet);
        listing.setPrice(price);
        listing.setListingOwner(listingOwner);
        listing.setDaysOnGrumble(daysOnGrumble);
        listing.setListingType(listingType);

        return listing;
    }
}
