package app.repository.impl;

import app.entity.Review;
import app.repository.api.ReviewRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepositoryImpl extends AbstractRepository<Review> implements ReviewRepository {

    @Override
    protected Class<Review> getEntityClass() {
        return Review.class;
    }
}
