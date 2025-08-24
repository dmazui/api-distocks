package com.dimaz.api_distocks.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AcaoRequest(
        @NotBlank @Size(max = 16) String ticker,
        @NotBlank @Size(max = 120) String nome,
        @Size(max = 80) String setor
) {}
