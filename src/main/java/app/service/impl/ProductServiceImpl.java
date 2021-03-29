package app.service.impl;

import app.dto.ProductDto;
import app.entity.Product;
import app.repository.api.ProductRepository;
import app.service.api.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractService<Product, ProductDto> implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        super(productRepository, modelMapper);
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto findByName(String name) {
        Product product = productRepository.findByName(name);
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
