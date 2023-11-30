package com.example.Foodease.Controller;


import com.example.Foodease.DTO.LoginDetails;
import com.example.Foodease.DTO.UserTypeDTO;
import com.example.Foodease.Model.LoginReg;
import com.example.Foodease.Service.RegLoginService;
import com.example.Foodease.Service.UserTypeDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("RegLogin")
@CrossOrigin
public class RegLoginController {

    @Autowired
    RegLoginService regLoginService;

    @Autowired
    UserTypeDTOService userTypeDTOService;

    @GetMapping("AllUsers")
    public List<LoginReg> getRegDetails() {
        return regLoginService.getRegDetails();
    }

    @GetMapping("LoadRoles")
    public List<UserTypeDTO> getAllUserTypes() {
        return userTypeDTOService.getAllUserTypes();
    }

    @PostMapping("Registration")
    public ResponseEntity<Object> regUser(@RequestBody LoginReg loginReg) {
        System.out.println("............");
        System.out.println(loginReg);

        return regLoginService.regUser(loginReg);

    }

    @PostMapping("Login")
    public ResponseEntity<LoginDetails> login(@RequestBody LoginReg loginReg) {
    //public ResponseEntity<String> login(@RequestParam LoginReg loginReg) {

        return regLoginService.login(loginReg);

    }
    @PutMapping("UserUpdate")
    public ResponseEntity<LoginReg> updateProfile(@RequestBody LoginReg loginReg) {

        return regLoginService.updateProfile(loginReg);

    }
}
