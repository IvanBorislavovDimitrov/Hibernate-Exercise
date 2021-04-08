package app.controller;

import app.dto.ReviewDto;
import app.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewDto> add(@RequestBody @Valid ReviewDto reviewDto) {
        reviewService.save(reviewDto);
        return ResponseEntity.ok(reviewDto);
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto>> findAll() {
        List<ReviewDto> reviews = reviewService.findAll();
        return ResponseEntity.ok(reviews);
    }

    @PutMapping
    public ResponseEntity<ReviewDto> update(@RequestBody @Valid ReviewDto reviewDto) {
        reviewService.update(reviewDto);
        return ResponseEntity.ok(reviewDto);
    }
}
