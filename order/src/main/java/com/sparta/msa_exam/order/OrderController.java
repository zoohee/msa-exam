package com.sparta.msa_exam.order;


import com.sparta.msa_exam.order.dto.request.AddOrderRequest;
import com.sparta.msa_exam.order.dto.request.AddProductToOrderRequest;
import com.sparta.msa_exam.order.dto.response.AddOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{orderId}")
    public ResponseEntity<AddOrderResponse> addProductToOrder(@PathVariable Long orderId,
                                                              @RequestBody AddProductToOrderRequest request) {
        return ResponseEntity.ok(orderService.addProductToOrder(orderId, request));
    }

}
