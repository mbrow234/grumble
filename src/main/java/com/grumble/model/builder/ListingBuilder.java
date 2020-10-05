package com.grumble.model.builder;

import com.grumble.common.AnimalType;
import com.grumble.common.ListingType;
import com.grumble.model.Listing;
import com.grumble.model.PetAge;
import com.grumble.model.User;

import java.util.List;

public class ListingBuilder {

    private String petName;
    private PetAge petAge;
    private AnimalType animalType;
    private double price;
    private User listingOwner;
    private int daysOnGrumble;
    private List<String> listingImages;
    private ListingType listingType;

    public ListingBuilder withPetName(String petName) {
        this.petName = petName;
        return this;
    }

    public ListingBuilder withPetAge(PetAge petAge) {
        this.petAge = petAge;
        return this;
    }

    public ListingBuilder withAnimalType(AnimalType animalType) {
        this.animalType = animalType;
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

    public ListingBuilder withListingImages(List<String> listingImages) {
        this.listingImages = listingImages;
        return this;
    }

    public ListingBuilder withListingType(ListingType listingType) {
        this.listingType = listingType;
        return this;
    }

    public Listing build() {
        Listing listing = new Listing();

        listing.setPetName(petName);
        listing.setPetAge(petAge);
        listing.setAnimalType(animalType);
        listing.setPrice(price);
        listing.setListingOwner(listingOwner);
        listing.setDaysOnGrumble(daysOnGrumble);
        listing.setListingImages(listingImages);
        listing.setListingType(listingType);

        return listing;
    }
}
