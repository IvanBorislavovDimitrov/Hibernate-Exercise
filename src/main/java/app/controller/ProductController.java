package app.controller;

import app.dto.ProductDto;
import app.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductDto> add(@RequestBody @Valid ProductDto productDto) {
        productService.save(productDto);
        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<ProductDto> delete(@PathVariable String productId) {
        productService.delete(productId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody @Valid ProductDto productDto) {
        productService.update(productDto);
        return ResponseEntity.ok(productDto);
    }

}
