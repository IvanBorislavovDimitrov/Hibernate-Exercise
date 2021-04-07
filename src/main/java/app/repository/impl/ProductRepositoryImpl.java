package app.repository.impl;

import app.entity.Product;
import app.repository.api.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class ProductRepositoryImpl extends AbstractRepository<Product> implements ProductRepository {

    @Override
    public Product findByName(String name) {
        return executeInTransaction(entityManager -> {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
            Root<Product> root = criteriaQuery.from(Product.class);
            CriteriaQuery<Product> where = criteriaQuery.where(criteriaBuilder.equal(root.get("name"), name));
            TypedQuery<Product> query = entityManager.createQuery(where);
            return query.getSingleResult();
        });
    }

    @Override
    public void delete(String id) {
        executeInTransaction(entityManager -> {
            Product product = entityManager.find(getEntityClass(), id);
            product.getBrand().getProducts().remove(product);
            product.getManufacturer().getProducts().remove(product);
            product.getCategory().getProducts().remove(product);
            return null;
        });
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

}
