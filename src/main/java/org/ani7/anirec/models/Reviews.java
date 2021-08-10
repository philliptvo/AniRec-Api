package org.ani7.anirec.models;

import javax.persistence.*;

@Entity
@Table(name = "Reviews")
public class Reviews {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int reviewId;
  private int score;
  private String review;
  @ManyToOne
  @JoinColumn(name = "AnimeId")
  private Anime anime;
  @ManyToOne
  @JoinColumn(name = "UserName")
  private User user;

  public Reviews() {
  }

  public Reviews(int reviewId, int score, String review, Anime anime, User user) {
    this.reviewId = reviewId;
    this.score = score;
    this.review = review;
    this.anime = anime;
    this.user = user;
  }

  public Reviews(int score, String review, Anime anime, User user) {
    this.score = score;
    this.review = review;
    this.anime = anime;
    this.user = user;
  }

  public Reviews(int reviewId) {
    this.reviewId = reviewId;
  }

  public int getReviewId() {
    return reviewId;
  }

  public void setReviewId(int reviewId) {
    this.reviewId = reviewId;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public Anime getAnime() {
    return anime;
  }

  public void setAnime(Anime anime) {
    this.anime = anime;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}