package sit.int202.classicmodelfri.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import sit.int202.classicmodelfri.entities.Office;

import java.util.List;
import java.util.Spliterator;

public class OfficeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FIND_ALL").getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public List<String> getAllCountry() {
        return getEntityManager().createNamedQuery("OFFICE.GET_ALL_COUNTRY").getResultList();
    }
    public List<String> getAllCity(){
        return getEntityManager().createNamedQuery("OFFICE.GET_ALL_CITY").getResultList();
    }

    public Office findOfficeByCode(String officeCode){
        return getEntityManager().find(Office.class, officeCode);
    }

//    public void close(){
//        if(entityManager != null || entityManager.isOpen()){
//            entityManager.close();
//        }
//    }

    public boolean insert(Office office) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(String officeCode) {
        EntityManager entityManager = getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
                return true;
        }
        return false;
    }

    public boolean update(Office newOffice) {
        if (newOffice != null) {
            EntityManager entityManager = getEntityManager();
            Office office = find(newOffice.getOfficeCode());
            if (office != null) {
                entityManager.getTransaction().begin();
                //set all attribute office with newOffice
                entityManager.getTransaction().commit();
                return true;
            }
        }
        return false;
    }

    public List<Office> findByCityOrCountry(String cityCountry) {
        cityCountry = cityCountry.toLowerCase() + '%';
        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityCountry);
        query.setParameter("country", cityCountry);
        return query.getResultList();
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
