package com.grumble.dto;

import com.grumble.common.ListingType;

public class ListingDto {

    private Long id;
    private PetDto petDto;
    private double price;
    private UserDto listingOwner;
    private int daysOnGrumble;
    private ListingType listingType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetDto getPetDto() {
        return petDto;
    }

    public void setPetDto(PetDto petDto) {
        this.petDto = petDto;
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

    public UserDto getListingOwner() {
        return listingOwner;
    }

    public void setListingOwner(UserDto listingOwner) {
        this.listingOwner = listingOwner;
    }

    public int getDaysOnGrumble() {
        return daysOnGrumble;
    }

    public void setDaysOnGrumble(int daysOnGrumble) {
        this.daysOnGrumble = daysOnGrumble;
    }
}
