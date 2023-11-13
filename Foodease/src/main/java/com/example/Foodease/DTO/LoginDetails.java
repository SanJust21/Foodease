package com.example.Foodease.DTO;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class LoginDetails {

    @Id
    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone Number must be 10 digits")
    @Size(max = 200)
    public String phoneNo;

    @Size(max = 300)
    public String name;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public boolean isTerms() {
        return terms;
    }

    public void setTerms(boolean terms) {
        this.terms = terms;
    }

    public String redirectUrl;

    public boolean terms;

//    @Enumerated(EnumType.STRING)
//    private UserRole role;


//    public UserRole getRole() {
//        return role;
//    }
//
//
//    public void setRole(UserRole role) {
//        this.role = role;
//    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(max = 300)
    public String location;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
