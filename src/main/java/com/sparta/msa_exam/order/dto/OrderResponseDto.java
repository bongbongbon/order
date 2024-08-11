package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.entity.Order;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

    private String name;

    public static OrderResponseDto fromEntity(Order order) {
        return OrderResponseDto.builder()
                .name(order.getName())
                .build();
    }

}
