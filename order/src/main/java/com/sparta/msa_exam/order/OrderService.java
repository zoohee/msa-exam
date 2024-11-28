package com.sparta.msa_exam.order;

import com.sparta.msa_exam.order.client.ProductClient;
import com.sparta.msa_exam.order.client.ProductDto;
import com.sparta.msa_exam.order.dto.request.AddOrderRequest;
import com.sparta.msa_exam.order.dto.response.AddOrderResponse;
import com.sparta.msa_exam.order.entity.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public AddOrderResponse addOrder(AddOrderRequest request) {
        List<ProductDto> products = request.productIds().stream()
                .map(productClient::getProduct)
                .collect(Collectors.toList());
        Order order = orderRepository.save(Order.create(products));
        return AddOrderResponse.from(order.getId());
    }
}