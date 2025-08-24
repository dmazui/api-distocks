package com.dimaz.api_distocks.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("status")
public class StatusController {

    @GetMapping
    public String inicial () {

        return """
                {
                    "projeto": "Api-DiStocks v1",
                    "status": "online",
                    "data/hora": "%s"
                }
                """.formatted(LocalDateTime.now());
    }
}
