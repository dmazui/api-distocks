package com.dmazui.apidistocks.controller;

import com.dmazui.apidistocks.dto.StockDTO;
import com.dmazui.apidistocks.entity.Stock;
import com.dmazui.apidistocks.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @PostMapping
    public StockDTO create(@RequestBody Stock stock) {
        return service.create(stock);
    }

    @GetMapping
    public List<StockDTO> findAll() {
        return service.findAll();
    }
}
