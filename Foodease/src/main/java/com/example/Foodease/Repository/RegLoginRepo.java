package com.example.Foodease.Repository;

import com.example.Foodease.Model.LoginReg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegLoginRepo extends JpaRepository<LoginReg, Integer> {
    Optional<LoginReg> findByPhoneNo(String phoneNo);
}
