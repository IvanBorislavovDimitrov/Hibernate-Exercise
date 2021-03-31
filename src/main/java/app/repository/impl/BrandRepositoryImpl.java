package app.repository.impl;

import app.entity.Brand;
import app.repository.api.BrandRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BrandRepositoryImpl extends AbstractRepository<Brand> implements BrandRepository {

    @Override
    protected Class<Brand> getEntityClass() {
        return Brand.class;
    }
}
