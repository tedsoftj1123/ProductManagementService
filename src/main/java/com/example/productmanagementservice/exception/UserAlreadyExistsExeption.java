package com.example.productmanagementservice.exception;

public class UserAlreadyExistsExeption extends BusinessException{
    public UserAlreadyExistsExeption() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
