package com.sfs.sellhappiness.domain.member.application;

import com.sfs.sellhappiness.domain.member.dao.MemberJpaRepository;
import com.sfs.sellhappiness.domain.member.domain.Member;
import com.sfs.sellhappiness.global.common.domain.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberDetailsServiceImpl implements UserDetailsService {

    private final MemberJpaRepository memberJpaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        memberJpaRepository.findByLoginInfo()

//        return null;

        Member member = Member.builder()
                .id(1L)
                .email("test@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .name("최민준")
                .build();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        return new org.springframework.security.core.userdetails.User(member.getEmail(), member.getPassword(), grantedAuthorities);
    }
}
