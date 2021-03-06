package app.dto;

import javax.validation.constraints.NotNull;

public class CategoryDto extends IdDto {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
