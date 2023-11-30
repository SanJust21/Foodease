package com.example.Foodease.Service;


import com.example.Foodease.DTO.UserTypeDTO;
import com.example.Foodease.Model.UserType;
import com.example.Foodease.Repository.UserTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTypeDTOService {
    @Autowired
    private UserTypeRepo userTypeRepo;

    public List<UserTypeDTO> getAllUserTypes() {
        List<UserType> userTypes = userTypeRepo.findAll();

        // Creating a list to store UserTypeDTO objects
        List<UserTypeDTO> userTypesDTO = new ArrayList<>();

        // Looping through each UserType and creating a UserTypeDTO
        for (UserType userType : userTypes) {
            UserTypeDTO transfer = new UserTypeDTO();
            transfer.setId(userType.getId());
            transfer.setRoleName(userType.getRoleName());

            // Adding the UserTypeDTO to the list
            userTypesDTO.add(transfer);
        }

        return userTypesDTO;
    }


}

