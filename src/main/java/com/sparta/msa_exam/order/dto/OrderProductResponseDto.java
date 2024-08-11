package com.sparta.msa_exam.order.dto;


import com.sparta.msa_exam.order.entity.OrderProduct;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductResponseDto {

    private Long id;

    private Long product_id;

    private OrderResponseDto order;

    public static OrderProductResponseDto fromEntity(OrderProduct orderProduct) {
        return OrderProductResponseDto.builder()
                .id(orderProduct.getId())
                .product_id(orderProduct.getProductId())
                .order(OrderResponseDto.fromEntity(orderProduct.getOrder()))
                .build();
    }
}
