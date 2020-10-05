package com.grumble.model;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String userSince;
    private Address address;

    public User() {

    }

    public User(String firstName, String lastName, String userSince, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userSince = userSince;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
