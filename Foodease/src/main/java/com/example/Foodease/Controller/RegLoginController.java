package com.example.Foodease.Controller;


import com.example.Foodease.DTO.LoginDetails;
import com.example.Foodease.Model.LoginReg;
import com.example.Foodease.Service.RegLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("RegLogin")
public class RegLoginController {

    @Autowired
    RegLoginService regLoginService;

    @GetMapping("AllUsers")
    public List<LoginReg> getRegDetails() {
        return regLoginService.getRegDetails();
    }
    @PostMapping("Registration")
    public ResponseEntity<String> regUser(@RequestBody LoginReg loginReg) {

        return regLoginService.regUser(loginReg);

    }

    @PostMapping("Login")
    public ResponseEntity<LoginDetails> login(@RequestBody LoginReg loginReg) {
    //public ResponseEntity<String> login(@RequestParam LoginReg loginReg) {

        return regLoginService.login(loginReg);

    }

}
