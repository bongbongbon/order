package com.sparta.msa_exam.order.controller;

import com.sparta.msa_exam.order.dto.OrderProductRequestDto;
import com.sparta.msa_exam.order.dto.OrderProductResponseDto;
import com.sparta.msa_exam.order.dto.OrderRequestDto;
import com.sparta.msa_exam.order.dto.OrderResponseDto;
import com.sparta.msa_exam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/order")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto) {

        return orderService.createOrder(orderRequestDto);
    }



    @PutMapping("/order/{orderId}")
    public OrderResponseDto updateOrder(@PathVariable(name = "orderId") Long orderId,
                                                      @RequestBody OrderProductRequestDto requestDto) {

       return orderService.createOrderProduct(orderId, requestDto);
    }



}
