package app.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Collections;
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
    private List<UserDto> buyers = Collections.emptyList();

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
}
