package org.ani7.anirec.services;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Reviews;
import org.ani7.anirec.models.User;
import org.ani7.anirec.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReviewsService {

  @Autowired
  private ReviewsRepository repository;

  public Page<Reviews> findAllReviews(int pageNum, int pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);

    return repository.findAll(pageable);
  }

  public void saveReview(Reviews review) {
    repository.save(review);
  }


  public Reviews getReviewById(int reviewId) {
    return repository.findById(reviewId).orElse(null);
  }

  public List<Reviews> getReviewByUser(User user) {
    return repository.findByUser(user);
  }

  public List<Reviews> getReviewByAnime(Anime anime) {
    return repository.findByAnime(anime);
  }

  public String deleteReviewById(Integer reviewId) {
    repository.deleteById(reviewId);
    return "Review " + reviewId + "has been removed!";
  }
}
