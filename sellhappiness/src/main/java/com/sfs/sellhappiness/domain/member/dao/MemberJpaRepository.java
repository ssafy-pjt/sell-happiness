package com.sfs.sellhappiness.domain.member.dao;

import com.sfs.sellhappiness.domain.member.domain.Member;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.email = :email and m.emailDomain = :emailDomain and m.password = :password")
    Member findByLoginInfo(String e);

//    private String email;
//    private String emailDomain;
//    private String password;

}
