package com.sparta.msa_exam.order.dto.response;

import com.sparta.msa_exam.order.client.ProductDto;
import com.sparta.msa_exam.order.entity.Order;
import java.util.List;
import java.util.stream.Collectors;

public record GetOrderResponse(
        Long orderId,
        List<Long> productIds
) {
    public static GetOrderResponse from(Order order) {
        List<Long> productIds = order.getOrderItems().stream()
                .map(ProductDto::getProductId)
                .toList();
        return new GetOrderResponse(order.getId(), productIds);
    }
}
