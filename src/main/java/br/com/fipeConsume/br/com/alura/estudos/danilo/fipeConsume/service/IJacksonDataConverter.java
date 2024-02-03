package br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.service;

import java.util.List;

public interface IJacksonDataConverter {
    <T> T getData(String content, Class<T> genericClass);

    <T> List<T> getList(String content, Class<T> genericClass);
}
