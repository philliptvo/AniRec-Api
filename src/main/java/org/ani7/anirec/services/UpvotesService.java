package org.ani7.anirec.services;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Upvotes;
import org.ani7.anirec.models.User;
import org.ani7.anirec.repositories.UpvotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UpvotesService {

  @Autowired
  private UpvotesRepository repository;

  public Page<Upvotes> findAllUpvotes(int pageNum, int pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    return repository.findAll(pageable);
  }

  public Upvotes saveUpvote(Upvotes upvote) {
    return repository.save(upvote);
  }

  public Upvotes getUpvoteById(int upvoteId) {
    return repository.findById(upvoteId).orElse(null);
  }

  public List<Upvotes> getUpvoteByUser(User user) {
    return repository.findByUser(user);
  }

//  public List<Upvotes> getUpvoteByAnime(Anime anime) {
//    return repository.findByAnime(anime);
//  }

  public String deleteUpvoteById(Integer upvoteId) {
    repository.deleteById(upvoteId);
    return "Review " + upvoteId + "has been removed!";
  }
}