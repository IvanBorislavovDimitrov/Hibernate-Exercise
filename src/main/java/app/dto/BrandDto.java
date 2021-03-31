package app.dto;

import app.entity.Product;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

public class BrandDto extends IdDto {

    @NotNull
    private String name;
    @NotNull
    private String description;
    private List<Product> products = Collections.emptyList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
