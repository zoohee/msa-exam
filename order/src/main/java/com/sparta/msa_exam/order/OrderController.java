package com.sparta.msa_exam.order;


import com.sparta.msa_exam.order.dto.request.AddOrderRequest;
import com.sparta.msa_exam.order.dto.request.AddProductToOrderRequest;
import com.sparta.msa_exam.order.dto.response.AddOrderResponse;
import com.sparta.msa_exam.order.dto.response.GetOrderResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @Value("${server.port}")
    private String port;

    private final OrderService orderService;

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Server-Port", port);
    }

    @PostMapping()
    public ResponseEntity<GetOrderResponse> addOrder(@RequestBody AddOrderRequest request) {

        return ResponseEntity.ok(orderService.addOrder(request));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<AddOrderResponse> addProductToOrder(@PathVariable Long orderId,
                                                              @RequestBody AddProductToOrderRequest request) {
        return ResponseEntity.ok(orderService.addProductToOrder(orderId, request));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

}
