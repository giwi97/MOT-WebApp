package com.mot.wappmot.repository;

import com.mot.wappmot.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByUserName(String userName);

}
