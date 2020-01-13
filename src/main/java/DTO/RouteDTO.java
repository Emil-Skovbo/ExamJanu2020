/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Cargo;
import entities.Delivery;
import entities.Driver;
import entities.Truck;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Bruger
 */
public class RouteDTO {
    
    private Integer id;
    private String driverName;
    private String truckName;
    private int capacity;
    private List<Cargo> cargo;
    private String shippingDate;
    private String fromLocation;
    private String destination;
    private String cargoName;
    private int weight;
    private int Units;
    
    
    public RouteDTO(){}

    public RouteDTO(Driver driver, Truck truck, Delivery delivery, Cargo cargo) {
        this.driverName = driver.getName();
        this.truckName = truck.getName();
        this.capacity = truck.getCapacity();
        this.cargo = delivery.getCargo();
        this.shippingDate = delivery.getShippingDate();
        this.fromLocation = delivery.getFromLocation();
        this.destination = delivery.getDestination();
        this.cargoName = cargo.getName();
        this.weight = cargo.getWeight();
        this.Units = cargo.getUnits();
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getUnits() {
        return Units;
    }

    public void setUnits(int Units) {
        this.Units = Units;
    }

    @Override
    public String toString() {
        return "RouteDTO{" + "id=" + id + ", driverName=" + driverName + ", truckName=" + truckName + ", capacity=" + capacity + ", cargo=" + cargo + ", shippingDate=" + shippingDate + ", fromLocation=" + fromLocation + ", destination=" + destination + ", cargoName=" + cargoName + ", weight=" + weight + ", Units=" + Units + '}';
    }

    
    
}
