package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAPersistence {
    private EntityManagerFactory emf;
    private EntityManager em;

    public boolean openConnection() {
        try {
            emf = Persistence.createEntityManagerFactory("ProjetoLPOOE1PU");
            em = emf.createEntityManager();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeConnection() {
        if (em != null) em.close();
        if (emf != null) emf.close();
    }

    public void persist(Object entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
