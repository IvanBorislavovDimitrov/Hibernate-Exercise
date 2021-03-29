package app.dto;

public class ReviewDto extends IdDto {

    private String text;
    private int stars;
    private ProductDto product;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
