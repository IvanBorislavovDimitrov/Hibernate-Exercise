package app.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "products")
public class Product extends IdEntity {

    @Column(nullable = false)
    private String name;
    @Lob
    private String description;
    @Column(name = "product_price", nullable = false)
    @Min(0)
    private BigDecimal productPrice;
    @Column(name = "shipping_price", nullable = false)
    @Min(0)
    private BigDecimal shippingPrice;
    @Column(name = "return_perion", nullable = false) // TODO: Fix
    @Min(0)
    private int returnPeriod;
    @ManyToMany
    @JoinTable(name = "products_buyers", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> buyers = Collections.emptyList();
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @OneToMany(mappedBy = "product", targetEntity = Review.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Review> reviews = Collections.emptyList();

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

    public List<User> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<User> buyers) {
        this.buyers = buyers;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
