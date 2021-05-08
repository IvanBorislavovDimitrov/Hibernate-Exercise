package app.service.api;

import app.dto.ProductDto;

import java.util.List;

public interface ProductService extends Service<ProductDto> {

    ProductDto findByName(String name);

    ProductDto buyProduct(String productId, String userId);

    List<ProductDto> findProductsByManufacturerName(String manufacturerName);

}
