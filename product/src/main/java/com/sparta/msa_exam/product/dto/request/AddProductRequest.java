package com.sparta.msa_exam.product.dto.request;

public record AddProductRequest(
        String name,
        Integer supplyPrice
) {
}
