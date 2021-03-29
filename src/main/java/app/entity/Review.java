package app.entity;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review extends IdEntity {

    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private int stars;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int starts) {
        this.stars = starts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
