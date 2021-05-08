package app.repository.api;

import app.entity.Product;

import java.util.List;

public interface ProductRepository extends Repository<Product> {

    Product findByName(String name);

    List<Product> findProductsByManufacturerName(String manufacturerName);
}
