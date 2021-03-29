package app.service.api;

import app.dto.ProductDto;

public interface ProductService extends Service<ProductDto> {

    ProductDto findByName(String name);

}
