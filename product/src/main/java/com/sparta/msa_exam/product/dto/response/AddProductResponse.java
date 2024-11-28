package com.sparta.msa_exam.product.dto.response;

import com.sparta.msa_exam.product.entity.Product;

public record AddProductResponse(
        Long productId
) {
    public static AddProductResponse from(Product product) {
        return new AddProductResponse(product.getId());
    }
}
