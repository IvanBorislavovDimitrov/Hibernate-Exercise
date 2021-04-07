package app.repository.impl;

import app.entity.Manufacturer;
import app.entity.Product;
import app.repository.api.ManufacturerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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
    public void delete(String id) {
        Manufacturer manufacturer = executeInTransaction(entityManager -> entityManager.find(Manufacturer.class, id));
        executeInTransaction(entityManager -> {
            List<Product> products = manufacturer.getProducts();
            products.forEach(product -> {
                Product p = entityManager.find(Product.class, product.getId());
                p.getCategory().getProducts().remove(p);
                p.getBrand().getProducts().remove(p);
                p.getManufacturer().getProducts().remove(p);
                entityManager.remove(p);
            });
            return null;
        });
        executeInTransaction(entityManager -> {
            Manufacturer manufacturer1 = entityManager.find(Manufacturer.class, manufacturer.getId());
            entityManager.remove(manufacturer1);
            return null;
        });
    }

    @Override
    protected Class<Manufacturer> getEntityClass() {
        return Manufacturer.class;
    }
}
