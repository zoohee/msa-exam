package com.sparta.msa_exam.product;


import com.sparta.msa_exam.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    default Product getById(Long id) {
        return findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 상품입니다."));
    }
}
