package app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table
@Entity(name = "manufacturers")
public class Manufacturer extends IdEntity {

    @Column(nullable = false)
    private String name;
    @Column(name = "registered_at", nullable = false)
    private Date registeredAt;
    @OneToMany(mappedBy = "manufacturer", targetEntity = Product.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
