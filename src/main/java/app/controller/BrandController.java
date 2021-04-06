package app.controller;

import app.dto.BrandDto;
import app.service.api.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/brands", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<BrandDto> add(@RequestBody @Valid BrandDto brandDto) {
        brandService.save(brandDto);
        return ResponseEntity.ok(brandDto);
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> findAll() {
        List<BrandDto> brands = brandService.findAll();
        return ResponseEntity.ok(brands);
    }

    @PutMapping
    public ResponseEntity<BrandDto> update(@RequestBody @Valid BrandDto brandDto) {
        brandService.update(brandDto);
        return ResponseEntity.ok(brandDto);
    }

    @DeleteMapping(value = "/{brandId}")
    public ResponseEntity<BrandDto> delete(@PathVariable String brandId) {
        brandService.delete(brandId);
        return ResponseEntity.ok().build();
    }

}
