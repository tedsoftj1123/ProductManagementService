package com.example.productmanagementservice.exception;

public class ProductAlreadyExistsException extends BusinessException{
    public ProductAlreadyExistsException(){
        super(ErrorCode.PRODUCT_ALREADY_EXISTS);
    }
}
