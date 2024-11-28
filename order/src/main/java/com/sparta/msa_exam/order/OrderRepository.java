package com.sparta.msa_exam.order;

import com.sparta.msa_exam.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    default Order getById(Long orderId) {
        return findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("없는 주문 번호입니다."));
    }
}
