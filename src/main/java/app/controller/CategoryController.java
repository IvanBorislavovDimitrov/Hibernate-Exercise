package app.controller;

import app.dto.CategoryDto;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> add(@RequestBody @Valid CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> update(@RequestBody @Valid CategoryDto categoryDto) {
        categoryService.update(categoryDto);
        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping(value = "/{categoryId}")
    public ResponseEntity<CategoryDto> delete(@PathVariable String categoryId) {
        categoryService.delete(categoryId);
        return ResponseEntity.ok().build();
    }

}
