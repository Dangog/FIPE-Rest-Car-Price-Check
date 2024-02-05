package br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record VehicleBrandsData(@JsonAlias("codigo") String code,
                                @JsonAlias("nome") String name) {}
