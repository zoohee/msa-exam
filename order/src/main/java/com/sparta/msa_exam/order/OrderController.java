package com.sparta.msa_exam.order;


import com.sparta.msa_exam.order.dto.request.AddOrderRequest;
import com.sparta.msa_exam.order.dto.response.AddOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<AddOrderResponse> addOrder(@RequestBody AddOrderRequest request) {

        return ResponseEntity.ok(orderService.addOrder(request));
    }

}
