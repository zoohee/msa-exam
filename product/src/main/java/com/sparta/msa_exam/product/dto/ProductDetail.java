package com.sparta.msa_exam.product.dto;

import com.sparta.msa_exam.product.entity.Product;

public record ProductDetail (
        Long id,
        String name,
        Integer supplyPrice
) {
    public static ProductDetail from(Product product) {
        return new ProductDetail(product.getId(), product.getName(), product.getSupplyPrice());
    }
}
