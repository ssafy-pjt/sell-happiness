package com.sfs.sellhappiness.domain.member.dao;

import com.sfs.sellhappiness.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {

//    @Query("select m from Member m where m.email = :email and m.password = :password")
    Optional<Member> findByEmail(String email);

//    private String email;
//    private String emailDomain;
//    private String password;



}
