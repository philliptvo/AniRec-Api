package org.ani7.anirec.models;

import javax.persistence.*;

@Entity
@Table(name = "Upvotes")
public class Upvotes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int upvoteId;
  @ManyToOne
  @JoinColumn(name = "SnipId")
  private Snippets snippet;
  @ManyToOne
  @JoinColumn(name = "UserName")
  private User user;

  public Upvotes() {
  }

  public Upvotes(int upvoteId, Snippets snippet, User user) {
    this.upvoteId = upvoteId;
    this.snippet = snippet;
    this.user = user;
  }

  public Upvotes(Snippets snippet, User user) {
    this.snippet = snippet;
    this.user = user;
  }

  public int getUpvoteId() {
    return upvoteId;
  }

  public void setUpvoteId(int upvoteId) {
    this.upvoteId = upvoteId;
  }

  public Snippets getSnippet() {
    return snippet;
  }

  public void setSnippet(Snippets snippet) {
    this.snippet = snippet;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
