package app.repository.impl;

import app.entity.Manufacturer;
import app.entity.Product;
import app.repository.api.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

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
    public List<Product> findProductsByManufacturerName(String manufacturerName) {
        return executeInTransaction(entityManager -> {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
            Root<Product> productRoot = criteriaQuery.from(getEntityClass());
            criteriaQuery.select(productRoot);
            Join<Product, Manufacturer> join = productRoot.join("manufacturer", JoinType.INNER);
            criteriaQuery.where(criteriaBuilder.equal(join.get("name"), manufacturerName));
            TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();
        });
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

}
