package com.example.productmanagementservice.controller;

import com.example.productmanagementservice.controller.dto.req.MemberReqDto;
import com.example.productmanagementservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @PostMapping("/join")
    public String join(@RequestBody MemberReqDto req) {
        return memberService.join(req);
    }
    @PostMapping("/login")
    public String login(@RequestBody MemberReqDto req){
        return memberService.login(req);
    }
}
