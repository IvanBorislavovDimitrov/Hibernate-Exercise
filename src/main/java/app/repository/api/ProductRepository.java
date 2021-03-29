package app.repository.api;

import app.entity.Product;

public interface ProductRepository extends Repository<Product> {

    Product findByName(String name);
}
