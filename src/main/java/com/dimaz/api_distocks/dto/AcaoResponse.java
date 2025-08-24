package com.dimaz.api_distocks.dto;

public record AcaoResponse(
        Long id,
        String ticker,
        String nome,
        String setor,
        Double precoAtual //buscar no client
) {}