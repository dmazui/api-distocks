package com.dmazui.apidistocks.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
public class BrapiClient {

    private final RestTemplate restTemplate;

    public BrapiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BigDecimal getCurrentPrice(String ticker) {
        try {
            String url = "https://brapi.dev/api/quote/" + ticker;
            Map response = restTemplate.getForObject(url, Map.class);

            List<Map> results = (List<Map>) response.get("results");
            if (results != null && !results.isEmpty()) {
                Double price = (Double) results.get(0).get("regularMarketPrice");
                return BigDecimal.valueOf(price);
            }
        } catch (Exception e) {
            System.out.println("Error fetching price: " + e.getMessage());
        }
        return BigDecimal.ZERO;
    }
}
