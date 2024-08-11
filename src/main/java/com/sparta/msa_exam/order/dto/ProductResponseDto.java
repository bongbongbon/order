package com.sparta.msa_exam.order.dto;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {

    private Long id;

    private String name;

    private Integer supply_price;

}
