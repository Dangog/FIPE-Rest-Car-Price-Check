package br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehicle(@JsonAlias("Valor") String value,
                      @JsonAlias("Marca") String brand,
                      @JsonAlias("Modelo") String model,
                      @JsonAlias("AnoModelo") Integer year,
                      @JsonAlias("Combustivel") String fuelType) {
}
