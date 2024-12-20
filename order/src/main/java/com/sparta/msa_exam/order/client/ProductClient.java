package com.sparta.msa_exam.order.client;

import com.sparta.msa_exam.order.exception.InvalidProductException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product")
public interface ProductClient {

    Logger log = LoggerFactory.getLogger(ProductClient.class);

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProduct")
    @GetMapping("/products/{id}")
    ProductDto getProduct(@PathVariable("id") Long id);

    default ProductDto fallbackGetProduct(Long id, Throwable throwable) {
        log.error("Circuit breaker fallback triggered for productId={}, cause={}", id, throwable.getMessage());
        throw new InvalidProductException("잠시 후에 주문 추가를 요청해주세요.");
    }
}