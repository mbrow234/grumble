package com.grumble.entities;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_since")
    private String userSince;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

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
}
