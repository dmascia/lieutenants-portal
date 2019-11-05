package com.davemascia.lieutenants.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
public class Lifter {
    public enum Size {
        XS, S, M, L, XL, TWO_XL, THREE_XL, FOUR_XL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Email Address is required")
    private String email;
    private String street;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private String phone1;
    private String phone2;
    private Boolean isRemoved;
    private Boolean isNotLifter;
    private Size tshirtSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_lieutenant")
    @JsonBackReference
    private Lieutenant lieutenant;


    public Lifter() {
    }

    public Lifter(Integer id, @NotNull(message = "First name is required") String firstName, @NotNull(message = "Last name is required") String lastName, @NotNull(message = "Email Address is required") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Lifter(Integer id, @NotNull(message = "First name is required") String firstName, @NotNull(message = "Last name is required") String lastName, @NotNull(message = "Email Address is required") String email, String street, String street2, String city, String state, String zip, String phone1, String phone2, Boolean isRemoved, Boolean isNotLifter, Size tshirtSize, Lieutenant lieutenant) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.isRemoved = isRemoved;
        this.isNotLifter = isNotLifter;
        this.tshirtSize = tshirtSize;
        this.lieutenant = lieutenant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Size getTshirtSize() {
        return tshirtSize;
    }

    public void setTshirtSize(Size tshirtSize) {
        this.tshirtSize = tshirtSize;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }

    public Boolean getNotLifter() {
        return isNotLifter;
    }

    public void setNotLifter(Boolean notLifter) {
        isNotLifter = notLifter;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public Lieutenant getLieutenant() {
        return lieutenant;
    }

    public void setLieutenant(Lieutenant lieutenant) {
        this.lieutenant = lieutenant;
    }
}
