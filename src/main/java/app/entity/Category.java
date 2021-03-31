package app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends IdEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category", targetEntity = Product.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Product> products = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
