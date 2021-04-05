package app.service.impl;

import app.dto.ProductDto;
import app.entity.Brand;
import app.entity.Category;
import app.entity.Manufacturer;
import app.entity.Product;
import app.repository.api.BrandRepository;
import app.repository.api.CategoryRepository;
import app.repository.api.ManufacturerRepository;
import app.repository.api.ProductRepository;
import app.service.api.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractService<Product, ProductDto> implements ProductService {

    private final ProductRepository productRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ManufacturerRepository manufacturerRepository, CategoryRepository categoryRepository, BrandRepository brandRepository) {
        super(productRepository, modelMapper);
        this.productRepository = productRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public ProductDto findByName(String name) {
        Product product = productRepository.findByName(name);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Manufacturer manufacturer = manufacturerRepository.findByName(product.getManufacturer().getName());
        product.setManufacturer(manufacturer);
        manufacturer.getProducts().add(product);
        Category category = categoryRepository.findByName(product.getCategory().getName());
        product.setCategory(category);
        category.getProducts().add(product);
        Brand brand = brandRepository.findByName(productDto.getBrand().getName());
        product.setBrand(brand);
        productRepository.save(product);
        manufacturerRepository.save(manufacturer);
        categoryRepository.save(category);
        brandRepository.save(brand);
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    protected Class<ProductDto> getDtoClass() {
        return ProductDto.class;
    }
}
