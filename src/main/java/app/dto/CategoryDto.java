package app.dto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CategoryDto extends IdDto {

    @NotNull
    private String name;
    private List<ProductDto> products = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
