package br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Models(@JsonAlias("modelos") List<VehicleBrandsData> models) {
}
