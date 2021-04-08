package app.service.impl;

import app.dto.ProductDto;
import app.entity.*;
import app.repository.api.*;
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
    private final UserRepository userRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ManufacturerRepository manufacturerRepository, CategoryRepository categoryRepository, BrandRepository brandRepository, UserRepository userRepository) {
        super(productRepository, modelMapper);
        this.productRepository = productRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ProductDto findByName(String name) {
        Product product = productRepository.findByName(name);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Manufacturer manufacturer = manufacturerRepository.findByName(productDto.getManufacturer().getName());
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
    public void update(ProductDto productDto) {
        Product product = productRepository.find(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setProductPrice(productDto.getProductPrice());
        product.setReturnPeriod(productDto.getReturnPeriod());
        product.setShippingPrice(productDto.getShippingPrice());
        Manufacturer manufacturer = manufacturerRepository.findByName(productDto.getManufacturer().getName());
        product.setManufacturer(manufacturer);
        manufacturer.getProducts().add(product);
        Category category = categoryRepository.findByName(product.getCategory().getName());
        product.setCategory(category);
        category.getProducts().add(product);
        Brand brand = brandRepository.findByName(productDto.getBrand().getName());
        product.setBrand(brand);
        productRepository.update(product);
    }

    @Override
    public ProductDto buyProduct(String productId, String userId) {
        User user = userRepository.find(userId);
        Product product = productRepository.find(productId);
        product.getBuyers().add(user);
        user.getBoughtProducts().add(product);
        userRepository.update(user);
        return modelMapper.map(product, ProductDto.class);
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
