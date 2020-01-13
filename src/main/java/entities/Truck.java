/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author emils
 */
@Entity
public class Truck implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int capacity;
    @OneToMany
    private List<Delivery> delivery = new ArrayList();

    @JoinTable(name = "truckDrivers", joinColumns = {
        @JoinColumn(name = "truck_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "driver_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Driver> driver = new ArrayList();

//        @JoinTable(name = "hobby_person", joinColumns = {
//        @JoinColumn(name = "hobby_id", referencedColumnName = "id")}, inverseJoinColumns = {
//        @JoinColumn(name = "person_id", referencedColumnName = "id")})
//
//    @ManyToMany(mappedBy = "hobbyCollection")
//    private List<Person> personCollection = new ArrayList();
    public Truck() {
    }

    public Truck(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addDelivery(Delivery delivery) {
        this.delivery.add(delivery);
        delivery.setTruck(this);
    }
    public void addDriver(Driver driver) {
        this.driver.add(driver);
    }

    public List<Delivery> getDelivery() {
        return delivery;
    }

    public void setDelivery(List<Delivery> delivery) {
        this.delivery = delivery;
    }

    public List<Driver> getDriver() {
        return driver;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }

}
