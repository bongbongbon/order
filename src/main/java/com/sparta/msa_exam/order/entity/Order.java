package com.sparta.msa_exam.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderProduct> productIds = new ArrayList<>();
}
