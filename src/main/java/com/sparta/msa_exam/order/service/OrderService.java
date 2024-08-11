package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.client.ProductClient;
import com.sparta.msa_exam.order.dto.*;
import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.entity.OrderProduct;
import com.sparta.msa_exam.order.repository.OrderProductRepository;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;


    public OrderResponseDto createOrder(OrderRequestDto requestDto) {

        Order order = Order.builder()
                .name(requestDto.getName())
                .build();

        Order savedOrder = orderRepository.save(order);

        OrderProduct orderProduct = OrderProduct.builder()
                .order(savedOrder)
                .productId(requestDto.getProduct_id())
                .build();

        orderProductRepository.save(orderProduct);

        return OrderResponseDto.fromEntity(savedOrder);
    }


    public OrderResponseDto createOrderProduct(Long orderId, OrderProductRequestDto requestDto) {

            Order order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new RuntimeException("주문이 없습니다."));


            order.setProductIds(orderProductRepository.findByProductId(requestDto.getProduct_id())
                .orElseThrow(() -> new RuntimeException("주문상품이 없습니다.")));


            return OrderResponseDto.fromEntity(orderRepository.save(order));
    }
}
