package org.ani7.anirec.controllers;


import org.ani7.anirec.models.Reviews;
import org.ani7.anirec.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ReviewsController {
  @Autowired
  private ReviewsService service;

  @GetMapping("/reviews")
  public List<Reviews> getAllReviews(@RequestParam(defaultValue = "1")
      String pageNum, @RequestParam(defaultValue = "25") String pageSize) {
    Page<Reviews> page = service.findAllReviews(Integer.parseInt(pageNum), Integer.parseInt(pageSize));

    return page.getContent();
  }

  @GetMapping("/reviews/{id}")
  public ResponseEntity<Reviews> getReviewsById(@PathVariable Integer id) {
    try {
      Reviews review = service.getReviewById(id);
      return new ResponseEntity<>(review, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/reviews")
  public ResponseEntity<Reviews> createReview(Reviews review) {
    service.saveReview(review);
    return new ResponseEntity<>(review, HttpStatus.CREATED);
  }

  @PutMapping("/reviews/{id}")
  public ResponseEntity<Reviews> updateReview(Reviews review, @PathVariable Integer id) {
    try {
      Reviews oldReview = service.getReviewById(id);
      review.setReviewId(id);
      service.saveReview(review);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/reviews/{id}")
  public void deleteReview(@PathVariable Integer id) {
    service.deleteReviewById(id);
  }
}