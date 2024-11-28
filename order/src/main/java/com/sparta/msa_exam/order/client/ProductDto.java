package com.sparta.msa_exam.order.client;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
        private Long productId;
        private String name;
        private Integer price;
}