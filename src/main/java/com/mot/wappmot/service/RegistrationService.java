package com.mot.wappmot.service;

import com.mot.wappmot.model.User;
import com.mot.wappmot.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository regRepo;
    
    public User saveUser(User user){

        return regRepo.save(user);

    }

}
