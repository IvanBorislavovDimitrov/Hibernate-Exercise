package app.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDto extends IdDto {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal productPrice;
    @NotNull
    private BigDecimal shippingPrice;
    @NotNull
    private int returnPeriod;
    private List<UserDto> buyers = new ArrayList<>();
    @NotNull
    private BrandDto brand;
    @NotNull
    private CategoryDto category;
    @NotNull
    private ManufacturerDto manufacturer;

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

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public int getReturnPeriod() {
        return returnPeriod;
    }

    public void setReturnPeriod(int returnPeriod) {
        this.returnPeriod = returnPeriod;
    }

    public List<UserDto> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<UserDto> buyers) {
        this.buyers = buyers;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public ManufacturerDto getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerDto manufacturer) {
        this.manufacturer = manufacturer;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
