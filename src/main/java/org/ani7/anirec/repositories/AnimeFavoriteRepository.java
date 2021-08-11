package org.ani7.anirec.repositories;

import java.util.List;
import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.AnimeFavorite;
import org.ani7.anirec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeFavoriteRepository extends JpaRepository<AnimeFavorite, Integer> {

    List<AnimeFavorite> findByUser(User user);

    List<AnimeFavorite> findByAnime(Anime anime);
}
