package app.dto;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

public class UserDto extends IdDto {

    @NotNull
    private String username;
    @NotNull
    private String email;
    private List<ProductDto> boughtProducts = Collections.emptyList();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProductDto> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<ProductDto> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }
}
