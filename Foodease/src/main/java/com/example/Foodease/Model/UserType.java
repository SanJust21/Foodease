package com.example.Foodease.Model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERTYPE")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME")
    private UserRole roleName;

    @OneToMany(mappedBy = "userType")
    private Set<LoginReg> loginRegs = new HashSet<>();

    public int getId() {
        return id;
    }

    public UserRole getRoleName() {
        return roleName;
    }

    public void setRoleName(UserRole roleName) {
        this.roleName = roleName;
    }

    public UserType(UserRole roleName) {
        this.roleName = roleName;
    }

    public UserType(int id, UserRole roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public UserType(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<LoginReg> getLoginRegs() {
        return loginRegs;
    }

    public void setLoginRegs(Set<LoginReg> loginRegs) {
        this.loginRegs = loginRegs;
    }



}
