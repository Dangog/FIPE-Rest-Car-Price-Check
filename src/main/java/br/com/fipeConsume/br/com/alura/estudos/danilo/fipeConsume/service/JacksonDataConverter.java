package br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.Collection;
import java.util.List;

public class JacksonDataConverter implements IJacksonDataConverter {

    private ObjectMapper om = new ObjectMapper();
    @Override
    public <T> T getData(String content, Class<T> genericClass) {
        try {
            return om.readValue(content,genericClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> getList(String content, Class<T> genericClass) {
        CollectionType list = om.getTypeFactory().constructCollectionType(List.class,genericClass);
        try {
            return om.readValue(content, list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
