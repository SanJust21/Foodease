package com.example.Foodease.DTO;

import com.example.Foodease.Model.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserTypeDTO {

    @Id
    private int id;

    public int getId() {
        return id;
    }

    public UserTypeDTO() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String roleName;

    public UserTypeDTO(UserType userType) {
        this.id = userType.getId();
        this.roleName = userType.getRoleName();
    }
}