package model;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.xml.ws.RequestWrapper;

public class EntityManagerHelper {
    @PersistenceUnit
    EntityManagerFactory factory;

    @Produces
    @RequestWrapper
    public EntityManager createEntityManager() {
        return factory.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager em) {
        em.close();
    }
}