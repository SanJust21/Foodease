package com.example.Foodease.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

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

        //@Enumerated(EnumType.STRING)
        //private UserRole role;

        //public UserRole getRole() {
        //        return role;
       // }

       // public void setRole(UserRole role) {
       //         this.role = role;
       // }

        //@NonNull
       // public int userId;
        @NonNull
        @ManyToOne
        @JoinColumn(name = "USERTYPE_ID") // References the USER_ID column in the USER table
        public UserType userType;

        public UserType getUser() {
                return userType;
        }

        public void setUser(UserType userType) {
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


        public LocalDateTime lastTimeIn;

        public LoginReg() {
                this.lastTimeIn = LocalDateTime.now();
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

        //public int getUserId() {
        //        return userId;
       // }

        //public void setUserId(int userId) {
        //        this.userId = userId;
        //}

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }
}
