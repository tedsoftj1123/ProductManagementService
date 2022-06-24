package com.example.productmanagementservice.service;

import com.example.productmanagementservice.controller.dto.req.ProductReqDto;
import com.example.productmanagementservice.domain.product.Product;
import com.example.productmanagementservice.domain.product.ProductRepository;
import com.example.productmanagementservice.exception.ProductAlreadyExistsException;
import com.example.productmanagementservice.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public String addProduct(ProductReqDto req) {

        if(productRepository.existsByProductName(req.getProductName()))
            throw new ProductAlreadyExistsException();
        productRepository.save(Product.builder()
                .productName(req.getProductName())
                .productPrice(req.getProductPrice())
                .productStock(req.getProductStock())
                .build());
        return "상품이름 : " + req.getProductName() + "\n" + "상품가격: " + req.getProductPrice() + "\n"
                +"상품 수량: " + req.getProductStock() + "\n요청이 성공적으로 접수되었습니다.";
    }

    public Optional<Product> showProduct(Long productId) {
        return productRepository.findById(productId);
    }

    public String delProject(Long productId) {
        productRepository.deleteById(productId);
        return "상품 id : " + productId + "가 삭제되었습니다.";
    }

    public String changeProduct(Long id, ProductReqDto req) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException:: new);
        product.setProductName(req.getProductName());
        product.setProductPrice(req.getProductPrice());
        product.setProductStock(req.getProductStock());
        return "상품정보 변경완료";
    }

    public List<Product> showAll() {
        return productRepository.findAll();
    }
}
