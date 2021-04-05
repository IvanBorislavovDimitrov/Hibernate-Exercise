package app.repository.impl;

import app.entity.Brand;
import app.repository.api.BrandRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class BrandRepositoryImpl extends AbstractRepository<Brand> implements BrandRepository {

    @Override
    public Brand findByName(String name) {
        return executeInTransaction(entityManager -> {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Brand> criteriaQuery = criteriaBuilder.createQuery(Brand.class);
            Root<Brand> root = criteriaQuery.from(Brand.class);
            CriteriaQuery<Brand> where = criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
            TypedQuery<Brand> query = entityManager.createQuery(where);
            return query.getSingleResult();
        });
    }

    @Override
    protected Class<Brand> getEntityClass() {
        return Brand.class;
    }
}
