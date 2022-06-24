package com.example.productmanagementservice.service;

import com.example.productmanagementservice.controller.dto.req.MemberReqDto;
import com.example.productmanagementservice.domain.member.Member;
import com.example.productmanagementservice.domain.member.MemberRepository;
import com.example.productmanagementservice.exception.UserAlreadyExistsExeption;
import com.example.productmanagementservice.exception.WrongPasswordException;
import com.example.productmanagementservice.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    @Transactional
    public String join(MemberReqDto req) {
        if(repository.existsByEmail(req.getEmail())) {
            throw new UserAlreadyExistsExeption();
        }
        repository.save(Member.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .roles(Collections.singletonList("ADMIN"))
                .build());
        return req.getEmail()+"님의 회원가입이 완료되었습니다.";
    }

    public String login(MemberReqDto req) {
        Member member = repository.findByEmail(req.getEmail())
                .orElseThrow(()-> new IllegalStateException("user not exists"));
        if(!passwordEncoder.matches(req.getPassword(), member.getPassword())) {
            throw new WrongPasswordException();
        }
        return jwtTokenProvider.createToken(member.getEmail(), member.getRoles());
    }
}
