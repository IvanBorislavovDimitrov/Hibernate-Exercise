package app.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ManufacturerDto extends IdDto {

    @NotNull
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date registeredAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

}
