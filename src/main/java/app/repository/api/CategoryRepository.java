package app.repository.api;

import app.entity.Category;

public interface CategoryRepository extends Repository<Category> {

    Category findByName(String name);
}
