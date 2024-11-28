package com.sparta.msa_exam.product.dto.response;

import com.sparta.msa_exam.product.entity.Product;

public record GetProductResponse (
        Long productId,
        String name,
        Integer price
) {
    public static GetProductResponse from(Product product) {
        return new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getSupplyPrice()
                );
    }
}
