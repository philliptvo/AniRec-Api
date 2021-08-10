package org.ani7.anirec.controllers;

import org.ani7.anirec.models.Reviews;
import org.ani7.anirec.payloads.ApiResponse;
import org.ani7.anirec.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

  @Autowired
  private ReviewsService service;

  @GetMapping("")
  public List<Reviews> getAllReviews(@RequestParam(defaultValue = "1") String pageNum,
                                     @RequestParam(defaultValue = "25") String pageSize) {
    Page<Reviews> page = service.findAllReviews(Integer.parseInt(pageNum) - 1,
                                                Integer.parseInt(pageSize));
    return page.getContent();
  }

  @GetMapping("{id}")
  public ResponseEntity<Reviews> getReviewsById(@PathVariable Integer id) {
    try {
      Reviews review = service.getReviewById(id);
      return new ResponseEntity<>(review, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("")
  public ResponseEntity<Reviews> createReview(@RequestBody Reviews review) {
    service.saveReview(review);
    return new ResponseEntity<>(review, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Reviews> updateReview(@RequestBody Reviews review, @PathVariable Integer id) {
    try {
      Reviews oldReview = service.getReviewById(id);
      review.setReviewId(id);
      service.saveReview(review);
      return new ResponseEntity<>(review, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteReview(@PathVariable Integer id) {
    try {
      service.deleteReviewById(id);
      return new ResponseEntity<>(new ApiResponse(true, "Review deleted successfully"),
                                  HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}