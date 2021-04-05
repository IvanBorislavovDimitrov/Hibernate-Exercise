package app.repository.impl;

import app.entity.Manufacturer;
import app.repository.api.ManufacturerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class ManufacturerRepositoryImpl extends AbstractRepository<Manufacturer> implements ManufacturerRepository {

    @Override
    public Manufacturer findByName(String name) {
        return executeInTransaction(entityManager -> {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Manufacturer> criteriaQuery = criteriaBuilder.createQuery(Manufacturer.class);
            Root<Manufacturer> root = criteriaQuery.from(Manufacturer.class);
            CriteriaQuery<Manufacturer> where = criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
            TypedQuery<Manufacturer> query = entityManager.createQuery(where);
            return query.getSingleResult();
        });
    }

    @Override
    protected Class<Manufacturer> getEntityClass() {
        return Manufacturer.class;
    }
}
