package app.repository.impl;

import app.entity.Product;
import app.entity.Review;
import app.repository.api.ReviewRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepositoryImpl extends AbstractRepository<Review> implements ReviewRepository {

    @Override
    public void delete(String id) {
        executeInTransaction(entityManager -> {
            Review review = entityManager.find(Review.class, id);
            Product product = review.getProduct();
            product.getReviews().remove(review);
            return null;
        });
    }

    @Override
    protected Class<Review> getEntityClass() {
        return Review.class;
    }
}
