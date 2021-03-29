package app.repository.impl;

import app.entity.Category;
import app.repository.api.CategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl extends AbstractRepository<Category> implements CategoryRepository {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
