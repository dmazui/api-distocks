package com.dmazui.apidistocks.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO {

    private Long id;
    private String ticker;
    private String name;
    private String sector;
    private BigDecimal purchasePrice;
    private BigDecimal currentPrice;
}
