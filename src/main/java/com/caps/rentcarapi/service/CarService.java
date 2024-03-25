package com.caps.rentcarapi.service;

import com.caps.rentcarapi.dto.CarDTO;
import com.caps.rentcarapi.entities.Car;
import com.caps.rentcarapi.exceptions.ResourceNotFoundException;
import com.caps.rentcarapi.mapper.ModelMapperConfig;
import com.caps.rentcarapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    @Transactional
    public List<CarDTO> findAll() {
        return ModelMapperConfig.parseListObject(repository.findAll(), CarDTO.class);
    }

    @Transactional
    public CarDTO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
        return ModelMapperConfig.parseObject(entity, CarDTO.class);
    }

    @Transactional
    public CarDTO create(CarDTO carDTO) {
        var car = ModelMapperConfig.parseObject(carDTO, Car.class);
        return ModelMapperConfig.parseObject(repository.save(car), CarDTO.class);
    }

    @Transactional
    public CarDTO update(CarDTO carDTO) {
        var car = repository.findById(carDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
        car.setId(carDTO.getId());
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setPlate(carDTO.getPlate());
        car.setColor(carDTO.getColor());
        car.setYear(carDTO.getYear());
        car.setValuePerDay(carDTO.getValuePerDay());
        return ModelMapperConfig.parseObject(car, CarDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
        repository.delete(entity);
    }



}
