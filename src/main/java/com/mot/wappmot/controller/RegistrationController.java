package com.mot.wappmot.controller;

import com.mot.wappmot.model.User;
import com.mot.wappmot.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService regService;

    @PostMapping("/registeruser")
    public User registerUser(@RequestBody User user) throws Exception {

        String tempNIC = user.getNic();

        if (tempNIC != null && !"".equals(tempNIC)){

            User userObj = regService.fetchUserByNIC(tempNIC);

            if (userObj != null){
                throw new Exception("User With "+tempNIC+" is already exists");
            }

        }

        User userObj = null;
        userObj = regService.saveUser(user);
        return userObj;

    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {

        String tempNIC = user.getNic();
        String tempPassword = user.getPassword();
        User userObj = null;

        if (tempNIC != null && tempPassword != null){

            userObj = regService.fetchUserByNICAndPassword(tempNIC, tempPassword);

        }

        if (userObj == null){

            throw new Exception("Bad Credentials");

        }

        return userObj;

    }

}
