package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
//@NamedQuery(name = "Driver.deleteAllRows", query = "DELETE from Driver") testrrrr
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany//(cascade=CascadeType.PERSIST)
    private List<Truck> truck = new ArrayList();

    public Driver() {
    }

    public Driver(String name) {
        this.name = name;
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

    public List<Truck> getTruck() {
        return truck;
    }

    public void setTruck(List<Truck> truck) {
        this.truck = truck;
    }

    public void addTruck(Truck truck) {
        this.truck.add(truck);
        truck.addDriver(this);
    }

}
