package com.example.productmanagementservice.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PRODUCT_ALREADY_EXISTS(409, "Product Already Exists"),
    PRODUCT_NOT_FOUND(404, "Product not found"),
    USER_ALREADY_EXISTS(409, "User Already Exists"),
    WRONG_PASSWORD(401, "wrong password");
    private final int status;
    private final String message;
}
