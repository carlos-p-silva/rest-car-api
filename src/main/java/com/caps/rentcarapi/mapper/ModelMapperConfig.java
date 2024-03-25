package com.caps.rentcarapi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ModelMapperConfig {

    private static ModelMapper mapper = new ModelMapper();

    public static <D, O> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <D, O> List<D> parseListObject(List<O> origin, Class<D> destination) {
        List<D> objectsDestination = new ArrayList<>();
        for (O ori : origin) {
            objectsDestination.add(mapper.map(ori, destination));
        }
        return objectsDestination;
    }

}
