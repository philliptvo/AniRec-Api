package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Upvotes;
import org.ani7.anirec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UpvotesRepository extends JpaRepository<Upvotes, Integer> {
  List<Upvotes> findByUser(User user);

//  List<Upvotes> findByAnime(Anime anime);
}
