package app.service.impl;

import app.dto.ProductDto;
import app.dto.ReviewDto;
import app.entity.Review;
import app.repository.api.ReviewRepository;
import app.service.api.ProductService;
import app.service.api.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl extends AbstractService<Review, ReviewDto> implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductService productService;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ModelMapper modelMapper, ProductService productService) {
        super(reviewRepository, modelMapper);
        this.productService = productService;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void save(ReviewDto reviewDto) {
        ProductDto productDto = productService.findByName(reviewDto.getProduct().getName());
        reviewDto.setProduct(productDto);
        Review review = modelMapper.map(reviewDto, Review.class);
        reviewRepository.save(review);
    }

    @Override
    public void update(ReviewDto reviewDto) {
        Review newReview = modelMapper.map(reviewDto, getEntityClass());
        Review oldReview = reviewRepository.find(reviewDto.getId());
        newReview.setProduct(oldReview.getProduct());
        reviewRepository.update(newReview);
    }

    @Override
    protected Class<Review> getEntityClass() {
        return Review.class;
    }

    @Override
    protected Class<ReviewDto> getDtoClass() {
        return ReviewDto.class;
    }

}
