package com.example.productmanagementservice.controller.dto.req;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class ProductReqDto {
    @NotBlank(message = "상품이름은 공백이면 안됩니다.")
    private String productName;
    @NotNull
    @Min(value = 10 , message ="상품 가격이 너무 적습니다.")
    private Long productPrice;
    @NotNull @Min(value = 1) @Max(value = 9999)
    private Long productStock;
}
