package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Reviews;
import org.ani7.anirec.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
    List<Reviews> findByUser(User user);

    List<Reviews> findByAnime(Anime anime);

    @Query("SELECT r FROM Reviews r WHERE CONCAT(r.anime.title, ' ', r.review, ' ', r.user.userName) LIKE %?1%")
    Page<Reviews> search(String keyword, Pageable pageable);
}