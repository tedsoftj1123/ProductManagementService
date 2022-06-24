package com.example.productmanagementservice.controller;

import com.example.productmanagementservice.controller.dto.req.ProductReqDto;
import com.example.productmanagementservice.domain.product.Product;
import com.example.productmanagementservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductReqDto req) {
        return ResponseEntity.ok(productService.addProduct(req));
    }
    @GetMapping("/showproduct/{productId}")
    public Optional<Product> showProduct(@PathVariable Long productId) {
        return productService.showProduct(productId);
    }
    @DeleteMapping("/delete/{productId}")
    public String delProduct(@PathVariable Long productId) {
        return productService.delProject(productId);
    }

    @PutMapping("/change/{id}")
    public String changProduct(@PathVariable Long id, @RequestBody ProductReqDto req) {
        return productService.changeProduct(id, req);
    }
    @GetMapping("/showall")
    public List<Product> showAll() {
        return productService.showAll();
    }
}
