package com.sparta.msa_exam.product;

import com.sparta.msa_exam.product.dto.request.AddProductRequest;
import com.sparta.msa_exam.product.dto.response.AddProductResponse;
import com.sparta.msa_exam.product.dto.response.GetProductResponse;
import com.sparta.msa_exam.product.dto.response.GetProductsResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    @Value("${server.port}")
    private String port;

    private final ProductService productService;

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Server-Port", port);
    }

    @PostMapping
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody AddProductRequest request) {
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @GetMapping
    public ResponseEntity<GetProductsResponse> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "Server port: " + port;
    }
}
