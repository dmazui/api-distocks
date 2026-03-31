package com.dmazui.apidistocks.service;

import com.dmazui.apidistocks.client.BrapiClient;
import com.dmazui.apidistocks.dto.StockDTO;
import com.dmazui.apidistocks.entity.Stock;
import com.dmazui.apidistocks.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Stock saved = repository.save(stock);
        return toDTO(saved);
    }

    public List<StockDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private StockDTO toDTO(Stock stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .ticker(stock.getTicker())
                .name(stock.getName())
                .sector(stock.getSector())
                .purchasePrice(stock.getPurchasePrice())
                .currentPrice(brapiClient.getCurrentPrice(stock.getTicker()))
                .build();
    }
}
