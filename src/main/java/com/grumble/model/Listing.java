package com.grumble.model;

import com.grumble.common.AnimalType;
import com.grumble.common.ListingType;

import java.util.List;

public class Listing {

    private Long id;
    private String petName;
    private PetAge petAge;
    private AnimalType animalType;
    private double price;
    //private int amountOfPets;
    private User listingOwner;
    private int daysOnGrumble;
    private List<String> listingImages;
    private ListingType listingType;

    public Long getId() {
        return id;
    }

    public List<String> getListingImages() {
        return listingImages;
    }

    public ListingType getListingType() {
        return listingType;
    }

    public void setListingType(ListingType listingType) {
        this.listingType = listingType;
    }

    public void setListingImages(List<String> listingImages) {
        this.listingImages = listingImages;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public PetAge getPetAge() {
        return petAge;
    }

    public void setPetAge(PetAge petAge) {
        this.petAge = petAge;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getListingOwner() {
        return listingOwner;
    }

    public void setListingOwner(User listingOwner) {
        this.listingOwner = listingOwner;
    }

    public int getDaysOnGrumble() {
        return daysOnGrumble;
    }

    public void setDaysOnGrumble(int daysOnGrumble) {
        this.daysOnGrumble = daysOnGrumble;
    }
}
