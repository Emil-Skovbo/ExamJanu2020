/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author emils
 */
@Entity
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int weight;
    private int Units;
    @OneToMany
    private List<Delivery> delivery = new ArrayList();

    public Cargo() {
    }

    public Cargo(String name, int weight, int Units) {
        this.name = name;
        this.weight = weight;
        this.Units = Units;
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

    public List<Delivery> getDerlivery() {
        return delivery;
    }

    public void setDerlivery(List<Delivery> derlivery) {
        this.delivery = derlivery;
    }

    public void addDelivery(Delivery delivery) {
        this.delivery.add(delivery);
    }

    @Override
    public String toString() {
        return "Cargo{" + "id=" + id + ", name=" + name + ", weight=" + weight + ", Units=" + Units + '}';
    }

}
