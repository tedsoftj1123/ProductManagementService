package com.example.productmanagementservice.controller.dto.req;

import com.example.productmanagementservice.domain.Auth;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemberReqDto {
    private final String email;
    private final String password;
}
