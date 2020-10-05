package com.grumble.model;

import java.util.List;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String userSince;
    private Address address;
    private List<Listing> userListings;

    public User() {

    }

    public User(String firstName, String lastName, String userSince, Address address, List<Listing> userListings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userSince = userSince;
        this.address = address;
        this.userListings = userListings;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserSince() {
        return userSince;
    }

    public void setUserSince(String userSince) {
        this.userSince = userSince;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Listing> getUserListings() {
        return userListings;
    }

    public void setUserListings(List<Listing> userListings) {
        this.userListings = userListings;
    }
}
