package com.grumble.entities;

import com.grumble.common.ListingType;

import javax.persistence.*;

@Entity(name = "Listing")
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet pet;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User listingOwner;

    @Column(name = "days_on_grumble")
    private int daysOnGrumble;

    @Column(name = "listing_type")
    @Enumerated(EnumType.STRING)
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

    public ListingType getListingType() {
        return listingType;
    }

    public void setListingType(ListingType listingType) {
        this.listingType = listingType;
    }
}
