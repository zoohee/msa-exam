package com.sparta.msa_exam.product.dto.response;

import com.sparta.msa_exam.product.dto.ProductDetail;
import com.sparta.msa_exam.product.entity.Product;
import java.util.List;
import java.util.stream.Collectors;

public record GetProductsResponse(
        List<ProductDetail> products
) {
    public static GetProductsResponse from(List<Product> products) {
        List<ProductDetail> productDetails = products.stream()
                .map(ProductDetail::from)
                .collect(Collectors.toList());
        return new GetProductsResponse(productDetails);
    }
}
