package app.service.impl;

import app.dto.CategoryDto;
import app.entity.Category;
import app.repository.api.CategoryRepository;
import app.service.api.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends AbstractService<Category, CategoryDto> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        super(categoryRepository, modelMapper);
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    protected Class<CategoryDto> getDtoClass() {
        return CategoryDto.class;
    }
}
