package com.sparta.msa_exam.order.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    private String name;

    private Long product_id;

}
