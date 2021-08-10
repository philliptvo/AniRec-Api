package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Reviews;
import org.ani7.anirec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
  List<Reviews> findByUser(User user);

  List<Reviews> findByAnime(Anime anime);
}