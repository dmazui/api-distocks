package com.dmazui.apidistocks.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "brapiClient", url = "https://brapi.dev/api")
public interface BrapiClient {

    @GetMapping("/quote/{ticker}")
    Map getQuote(@PathVariable("ticker") String ticker);
}