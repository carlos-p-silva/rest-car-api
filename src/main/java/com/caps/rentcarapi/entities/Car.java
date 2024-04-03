package com.caps.rentcarapi.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String plate;
    private String color;
    private Integer year;
    private BigDecimal valuePerDay;
    private boolean avaible;

    @OneToMany(mappedBy = "car")
    private final Set<Booking> booking = new HashSet<>();

    public Car() {}

    public Car(String brand, String model, String plate, String color, Integer year, BigDecimal valuePerDay, boolean avaible) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.color = color;
        this.year = year;
        this.valuePerDay = valuePerDay;
        this.avaible = avaible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getValuePerDay() {
        return valuePerDay;
    }

    public void setValuePerDay(BigDecimal valuePerDay) {
        this.valuePerDay = valuePerDay;
    }

    public boolean isAvaible() {
        return avaible;
    }

    public void setAvaible(boolean avaible) {
        this.avaible = avaible;
    }

    public Set<Booking> getBooking() {
        return booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!Objects.equals(id, car.id)) return false;
        if (!Objects.equals(brand, car.brand)) return false;
        if (!Objects.equals(model, car.model)) return false;
        if (!Objects.equals(plate, car.plate)) return false;
        if (!Objects.equals(color, car.color)) return false;
        if (!Objects.equals(year, car.year)) return false;
        return Objects.equals(valuePerDay, car.valuePerDay);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (plate != null ? plate.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (valuePerDay != null ? valuePerDay.hashCode() : 0);
        return result;
    }
}
