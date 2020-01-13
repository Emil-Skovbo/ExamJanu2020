package facades;

import entities.Cargo;
import entities.Delivery;
import entities.Driver;
import entities.Truck;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MultiFacade {

    private static MultiFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MultiFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MultiFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MultiFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public long getDriverCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long renameMeCount = (long) em.createQuery("SELECT COUNT(r) FROM Driver r").getSingleResult();
            return renameMeCount;
        } finally {
            em.close();
        }

    }

    public List<Truck> getAllTrucks() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query = em.createQuery("SELECT c from Truck c", Truck.class);
            return query.getResultList();
        } finally {
            em.close();
        }

    }

    public Driver addDriver(String name) {
        EntityManager em = emf.createEntityManager();
        Driver driver = new Driver(name);
        try {
            em.getTransaction().begin();
            em.persist(driver);
            em.getTransaction().commit();
            return driver;
        } finally {
            em.close();
        }
    }

//        public String editCargo(String cRecipeJson, int id) {
//        CustomRecipe OriRec = getRecipeById(id);
//        CustomRecipe NewRec = gson.fromJson(cRecipeJson, CustomRecipe.class);
//        OriRec.setName(NewRec.getName());
//        OriRec.setPortion_size(NewRec.getPortion_size());
//        OriRec.setCooking_time(NewRec.getCooking_time());
//        OriRec.setIngredients(NewRec.getIngredients());
//        OriRec.setDescription(NewRec.getDescription());
//        return gson.toJson(OriRec);
//
//    }
    public Delivery getDeloveryById(int id) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Delivery> query //CustomRecipe
                    = em.createNamedQuery("Select D from Delivery D where D.id =:id", Delivery.class);
            return query.setParameter("id", id).getSingleResult();

        } finally {
            em.close();

        }
    }

    public Driver getDriverByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Driver> query
                    = em.createNamedQuery("Select R from Driver R where R.Name =:name", Driver.class);
            Driver result = query.setParameter("name", name).getSingleResult();
            return result;
        } finally {
            em.close();

        }
    }

    public void deleteCargo(int id) {
        EntityManager em = emf.createEntityManager();
        Cargo Cargo = em.find(Cargo.class, id);
        Cargo deletedCargo = Cargo;

        try {
            em.getTransaction().begin();
            em.remove(Cargo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        System.out.println(deletedCargo);
    }

    public void deleteDriver(int id) {
        EntityManager em = emf.createEntityManager();
        Driver driver = em.find(Driver.class, id);
        Driver deletedDriver = driver;

        try {
            em.getTransaction().begin();
            em.remove(driver);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        System.out.println(deletedDriver);
    }

    public long getTruckAmount() {
        EntityManager em = emf.createEntityManager(); //CUSTOMRECIPE
        try {
            long userCount = (long) em.createQuery("SELECT COUNT(R) FROM Truck R").getSingleResult();
            return userCount;
        } finally {
            em.close();
        }

    }

    public Delivery createDelivery(String fromlocation, String destination, Truck truck) {
        EntityManager em = emf.createEntityManager();
        //Date date = Calendar.getInstance().getTime();
        Delivery delivery = new Delivery("today", fromlocation, destination, truck);
        try {
            em.getTransaction().begin();
            em.persist(delivery);
            em.getTransaction().commit();
            return delivery;
        } finally {
            em.close();
        }

    }

    public void insertData() {
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
//            em.createNamedQuery("Cargo.deleteAllRows").executeUpdate();
//            em.createNamedQuery("Delivery.deleteAllRows").executeUpdate();
//            em.createNamedQuery("Truck.deleteAllRows").executeUpdate();
//            em.createNamedQuery("Driver.deleteAllRows").executeUpdate();
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
