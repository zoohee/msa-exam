package com.sparta.msa_exam.order.dto.response;

public record AddOrderResponse(
        Long orderId
) {
    public static AddOrderResponse from(Long orderId) {
        return new AddOrderResponse(orderId);
    }
}
