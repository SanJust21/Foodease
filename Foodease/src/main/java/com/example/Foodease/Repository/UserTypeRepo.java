package com.example.Foodease.Repository;


import com.example.Foodease.Model.UserRole;
import com.example.Foodease.Model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UserTypeRepo extends JpaRepository<UserType, Integer> {
    UserType findByRoleName(UserRole roleName);
}
