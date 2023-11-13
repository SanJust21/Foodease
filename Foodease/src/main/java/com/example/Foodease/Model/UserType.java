package com.example.Foodease.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "USERTYPE")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;

    public UserType() {
    }
    @Column(name = "ROLE_NAME")
    public String roleName;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "ROLE_NAME")
//    private UserRole roleName;
//
//    public UserRole getRoleName() {
//        return roleName;
//    }
//
//    public UserType(UserRole roleName) {
//        this.roleName = roleName;
//    }

//    public UserType(int id, UserRole roleName) {
//        this.id = id;
//        this.roleName = roleName;
//    }
//
//    public void setRoleName(UserRole roleName) {
//        this.roleName = roleName;
//    }


    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserType(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public UserType(String roleName) {
        this.roleName = roleName;
    }

    public UserType(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }





}
