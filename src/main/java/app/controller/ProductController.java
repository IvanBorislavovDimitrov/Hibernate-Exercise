package app.controller;

import app.dto.ProductDto;
import app.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
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
}
