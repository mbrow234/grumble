package com.grumble.model;

import com.grumble.common.ListingType;

public class Listing {

    private Long id;
    private Pet pet;
    private double price;
    private User listingOwner;
    private int daysOnGrumble;
    private ListingType listingType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public ListingType getListingType() {
        return listingType;
    }

    public void setListingType(ListingType listingType) {
        this.listingType = listingType;
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
