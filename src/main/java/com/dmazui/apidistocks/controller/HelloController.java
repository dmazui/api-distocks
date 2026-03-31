package com.dmazui.apidistocks.controller;

import com.dmazui.apidistocks.dto.StockDTO;
import com.dmazui.apidistocks.entity.Stock;
import com.dmazui.apidistocks.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public String hello() {
        return "api-DiStocks is online!";
    }
}
