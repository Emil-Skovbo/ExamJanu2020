/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * 
 */
public class MakeTestData {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Driver driver1 = new Driver("Jan");
        Driver driver2 = new Driver("Nick");
        Truck truck1 = new Truck("SpeedDevil", 1000);
        Truck truck2 = new Truck("Wolf", 1000);
        Cargo cargo1 = new Cargo("bread", 50, 120);
        Cargo cargo2 = new Cargo("beer", 500, 1000);
        //  Date date = Calendar.getInstance().getTime();
        Delivery delivery1 = new Delivery("Today", "Denmark", "Germany", truck1);
        Delivery delivery2 = new Delivery("Today", "Denmark", "HongKong", truck2);

        delivery1.addCargo(cargo1);
        truck1.addDelivery(delivery1);
        driver1.addTruck(truck1);

        delivery2.addCargo(cargo2);
        truck2.addDelivery(delivery2);
        driver2.addTruck(truck2);

        try {
            em.getTransaction().begin();
            em.persist(driver1);
            em.persist(truck1);
            em.persist(delivery1);
            em.persist(cargo1);

            em.persist(driver2);
            em.persist(truck2);
            em.persist(delivery2);
            em.persist(cargo2);

            em.getTransaction().commit();

        } finally {
            em.close();
        }

    }
}
