package com.sfs.sellhappiness.domain.member.dao;

import com.sfs.sellhappiness.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
