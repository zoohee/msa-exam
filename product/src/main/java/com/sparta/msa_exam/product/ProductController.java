package com.sparta.msa_exam.product;

import com.sparta.msa_exam.product.dto.request.AddProductRequest;
import com.sparta.msa_exam.product.dto.response.AddProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody AddProductRequest request) {
        return ResponseEntity.ok(productService.addProduct(request));
    }
}
