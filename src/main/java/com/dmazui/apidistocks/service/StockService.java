package com.dmazui.apidistocks.service;

import com.dmazui.apidistocks.client.BrapiClient;
import com.dmazui.apidistocks.dto.StockDTO;
import com.dmazui.apidistocks.entity.Stock;
import com.dmazui.apidistocks.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StockService {

    private final StockRepository repository;
    private final BrapiClient brapiClient;

    public StockService(StockRepository repository, BrapiClient brapiClient) {
        this.repository = repository;
        this.brapiClient = brapiClient;
    }

    public StockDTO create(Stock stock) {
        Stock  saved = repository.save(stock);
        return toDTO(saved);
    }

    public List<StockDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private StockDTO toDTO(Stock stock) {

        BigDecimal currentPrice = BigDecimal.ZERO;

        try {
            Map response = brapiClient.getQuote(stock.getTicker());

            var results = (List<Map>) response.get("results");
            if (results != null && !results.isEmpty()) {
                Double price = (Double) results.get(0).get("regularMarketPrice");
                currentPrice = BigDecimal.valueOf(price);
            }

        } catch (Exception e) {
            System.out.println("Error fetching price: " + e.getMessage());
        }

        return StockDTO.builder()
                .id(stock.getId())
                .ticker(stock.getTicker())
                .name(stock.getName())
                .sector(stock.getSector())
                .purchasePrice(stock.getPurchasePrice())
                .currentPrice(currentPrice)
                .build();
    }
}
