package app.repository.impl;

import app.entity.Category;
import app.repository.api.CategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CategoryRepositoryImpl extends AbstractRepository<Category> implements CategoryRepository {

    @Override
    public Category findByName(String name) {
        return executeInTransaction(entityManager -> {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
            Root<Category> root = criteriaQuery.from(Category.class);
            CriteriaQuery<Category> where = criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
            TypedQuery<Category> query = entityManager.createQuery(where);
            return query.getSingleResult();
        });
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
