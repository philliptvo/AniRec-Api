package org.ani7.anirec.services;

import org.ani7.anirec.models.Reviews;
import org.ani7.anirec.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewsService {

  @Autowired
  private ReviewsRepository repository;

  public Page<Reviews> findAllReviews(int pageNum, int pageSize) {
    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

    return repository.findAll(pageable);
  }

  public void saveReview(Reviews review) {
    repository.save(review);
  }


  public Reviews getReviewById(Integer reviewId) {
    return repository.getById(reviewId);
  }

  public void deleteReviewById(Integer reviewId) {
    repository.deleteById(reviewId);
  }
}
