package app.entity;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "brands")
public class Brand extends IdEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "brand", targetEntity = Product.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> products;

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
