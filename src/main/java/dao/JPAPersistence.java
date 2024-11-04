package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAPersistence {
    private static final String PERSISTENCE_UNIT_NAME = "ProjetoLPOOE1PU";
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    // Abre uma conexão com o banco de dados
    public boolean openConnection() {
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            entityManager = factory.createEntityManager();
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao abrir a conexão com o banco de dados: " + e.getMessage());
            return false;
        }
    }

    // Fecha a conexão com o banco de dados
    public void closeConnection() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }

    // Persiste um objeto no banco de dados
    public void persist(Object entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Erro ao persistir entidade: " + e.getMessage());
        }
    }

    // Atualiza um objeto no banco de dados
    public void update(Object entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Erro ao atualizar entidade: " + e.getMessage());
        }
    }

    // Remove um objeto do banco de dados
    public void remove(Object entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Erro ao remover entidade: " + e.getMessage());
        }
    }

    // Busca uma entidade pelo ID
    public <T> T find(Class<T> entityClass, Object primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    // Verifica se a conexão com o banco de dados está ativa
    public boolean isConnected() {
        return entityManager != null && entityManager.isOpen();
    }
}
