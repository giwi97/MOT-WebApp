package com.mot.wappmot.repository;

import com.mot.wappmot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Integer> {


    public User findByNICId(String nic);
}
