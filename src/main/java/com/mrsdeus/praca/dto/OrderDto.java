package com.mrsdeus.praca.dto;

import lombok.Data;

@Data
public class OrderDto {
    String category;
    String slug;
    int size;
    int amount;
}
