package com.sparta.msa_exam.order.entity;

import com.sparta.msa_exam.order.client.ProductDto;
import com.sparta.msa_exam.order.enums.OrderStatus;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns =
    @JoinColumn(name = "order_id"))
    private List<ProductDto> orderItems;

    public static Order create(List<ProductDto> products) {
        return Order.builder()
                .status(OrderStatus.CREATED)
                .orderItems(products)
                .build();
    }

    public void updateOrderItems(ProductDto product) {
        this.orderItems.add(product);
    }
}
