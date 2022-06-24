package com.example.productmanagementservice.exception;

public class WrongPasswordException extends BusinessException{
    public WrongPasswordException() {
        super(ErrorCode.WRONG_PASSWORD);
    }
}
