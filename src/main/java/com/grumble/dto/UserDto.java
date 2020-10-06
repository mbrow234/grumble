package com.grumble.dto;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String userSince;
    private AddressDto addressDto;

    public UserDto() {

    }

    public UserDto(String firstName, String lastName, String userSince, AddressDto addressDto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userSince = userSince;
        this.addressDto = addressDto;
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

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}