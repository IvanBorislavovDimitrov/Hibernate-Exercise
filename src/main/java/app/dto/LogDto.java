package app.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class LogDto extends IdDto {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date addedOn;
    @NotNull
    private String description;

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
