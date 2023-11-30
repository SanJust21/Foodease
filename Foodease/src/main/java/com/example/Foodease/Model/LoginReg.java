package com.example.Foodease.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "IM_REGISTER")
//@NoArgsConstructor

public class LoginReg {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
        @SequenceGenerator(name = "ID", sequenceName = "Reg_Id",allocationSize = 1)
        public int id;

//        @Enumerated(EnumType.STRING)
//        private UserRole role;
//
//        public UserRole getRole() {
//                return role;
//        }
//
//        public void setRole(UserRole role) {
//                this.role = role;
//        }


        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "USERTYPE_ID") // References the USER_ID column in the USERTYPE table
        @JsonProperty("userType")
        public UserType userType;

        public String getUsertypeString() {
                return usertypeString;
        }

        public void setUsertypeString(String usertypeString) {
                this.usertypeString = usertypeString;
        }

        @Transient
        private String usertypeString; // This field is used for JSON input

        public int getUserTypeId() {
                return userTypeId;
        }

        public void setUserTypeId(int userTypeId) {
                this.userTypeId = userTypeId;
        }

        @Transient
        private int userTypeId; // This field is used for JSON input

        public UserType getUserType() {
                return userType;
        }

        public void setUserType(UserType userType) {
                this.userType = userType;
        }

        @NotBlank(message = "Username cannot be blank")
        @Size(max = 300)
        public String name;

       // @NotBlank(message = "Email Id cannot be blank")
       // public String email;

        @Pattern(regexp = "\\d{10}", message = "Phone Number must be 10 digits")
        @Size(max = 200)
        public String phoneNo;
        @Size(max = 300)
        public String location;

        @NotBlank(message = "Password cannot be blank")
        @Size(max = 200)
       // @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
               // message = "Password must be at least 8 characters long and contain at least one letter and one number")
        //@Pattern(regexp = "^[A-Za-z\\d]{8,}$", message = "Password must be at least 8 characters long and contain letters and numbers")
        public String password;

        @Column(name = "terms")
        public boolean terms;

        public boolean isTerms() {
                return terms;
        }

        public void setTerms(boolean terms) {
                this.terms = terms;
        }

        public LocalDateTime lastTimeIn;

        public LoginReg() {
                this.lastTimeIn = LocalDateTime.now();
                this.userType = new UserType(); // Initialize UserType to avoid null
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public String getName() {
                return name;
        }

        public LocalDateTime getLastTimeIn() {
                return lastTimeIn;
        }

        public void setLastTimeIn(LocalDateTime lastTimeIn) {
                this.lastTimeIn = LocalDateTime.now();
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getPhoneNo() {
                return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
                this.phoneNo = phoneNo;
        }

        public void setName(String name) {
                this.name = name;
        }


        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setUserType(int userTypeId) {
        }
}
