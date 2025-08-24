package com.dimaz.api_distocks.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acoes", uniqueConstraints = {
        @UniqueConstraint(name = "uk_acao_ticker", columnNames = {"ticker"})
})
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 8)
    @Column(nullable = false, length = 8)
    private String ticker; // exemplo: PETR4

    @NotBlank
    @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String nome;

    @Size(max = 80)
    @Column(length = 80)
    private String setor;
}
