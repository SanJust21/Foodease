package com.example.Foodease.Service;

import com.example.Foodease.DTO.LoginDetails;
import com.example.Foodease.Exception.UserNotFoundException;
import com.example.Foodease.Model.LoginReg;
import com.example.Foodease.Model.UserRole;
import com.example.Foodease.Repository.RegLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
public class RegLoginService {

    @Autowired
    RegLoginRepo regLoginRepo;

    public List<LoginReg> getRegDetails() {
        return regLoginRepo.findAll();
    }

    public ResponseEntity<String> regUser(LoginReg loginReg) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String encryptedPwd = bCrypt.encode(loginReg.getPassword());
        loginReg.setPassword(encryptedPwd);
        Optional<LoginReg> exsistuser = regLoginRepo.findByPhoneNo(loginReg.getPhoneNo());
        if (exsistuser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with the provided phone number already exists");
        }

        LoginReg savedUser = regLoginRepo.save(loginReg);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser.getName() + " successfully registered!");

    }


    //public ResponseEntity<String> login(LoginReg loginReg) {
        public ResponseEntity<LoginDetails> login(LoginReg loginReg) throws UserNotFoundException {
            BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

            Optional<LoginReg> loginUser = regLoginRepo.findByPhoneNo(loginReg.getPhoneNo());
            if (loginUser.isPresent()) {
                LoginReg loginpass = loginUser.get();
                LoginDetails details = new LoginDetails();
                if (bCrypt.matches(loginReg.getPassword(), loginpass.getPassword())) {

                    loginpass.setLastTimeIn(LocalDateTime.now());
                    regLoginRepo.save(loginpass);

                    details.setPhoneNo(loginpass.getPhoneNo());
                    details.setName(loginpass.getName());
                    details.setLocation(loginpass.getLocation());
                    details.setRole(loginpass.getRole());

                    if (UserRole.ADMIN.equals(loginpass.getRole())) {
                        details.setRedirectUrl("/admin/dashboard");
                    } else if(UserRole.CUSTOMER.equals(loginpass.getRole())){
                        details.setRedirectUrl("/customer/dashboard");
                    } else
                        details.setRedirectUrl("/restaurant/dashboard");

                    return ResponseEntity.ok().body(details);
//
//                String token = Jwts.builder()
//                        .setSubject(loginpass.getPhoneNo()) // Use the user's phone number as the subject of the token
//                        .setIssuedAt(new Date())
//                        .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token expires in 24 hours
//                        .signWith(SignatureAlgorithm.HS512, "yourSecretKey") // Use your secret key to sign the token
//                        .compact();

//                Map<String, String> response = new HashMap<>();
//                response.put("token", token);
//                response.put("role", loginpass.getRole().toString());
//
//                return ResponseEntity.ok(response);
//

                } else throw new UserNotFoundException("Incorrect password");
                //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect Password");

                // } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
                //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
            }
            throw new UserNotFoundException("No user found for this phone number!");
        }
}

