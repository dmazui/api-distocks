package com.dmazui.apidistocks.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping
    public String status() {
        return "api-DiStocks is online!";
    }
}
