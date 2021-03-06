package app.repository.impl;

import app.entity.IdEntity;
import app.repository.api.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractRepository<E extends IdEntity> implements Repository<E> {

    protected final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("app");

    @Override
    public void save(E object) {
        executeInTransaction(entityManager -> {
            entityManager.persist(object);
            return null;
        });
    }

    @Override
    public E find(String id) {
        return executeInTransaction(entityManager -> entityManager.find(getEntityClass(), id));
    }

    @Override
    public void update(E object) {
        executeInTransaction(entityManager -> {
            entityManager.merge(object);
            return null;
        });
    }

    @Override
    public void delete(String id) {
        executeInTransaction(entityManager -> {
            E e = entityManager.find(getEntityClass(), id);
            entityManager.remove(e);
            return null;
        });
    }

    @Override
    public List<E> findAll() {
        return executeInTransaction(entityManager -> {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
            Root<E> root = criteriaQuery.from(getEntityClass());
            TypedQuery<E> allQuery = entityManager.createQuery(criteriaQuery.select(root));
            return allQuery.getResultList();
        });
    }

    @Override
    public void merge(E object) {
        executeInTransaction(entityManager -> {
            entityManager.merge(object);
            return null;
        });
    }

    protected <T> T executeInTransaction(Function<EntityManager, T> function) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        T object = null;
        try {
            object = function.apply(entityManager);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.clear();
            entityManager.close();
        }
        return object;
    }

    protected abstract Class<E> getEntityClass();

}
