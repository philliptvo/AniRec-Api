package org.ani7.anirec.repositories;

import java.util.List;
import org.ani7.anirec.models.Genre.GenreType;
import org.ani7.anirec.models.GenreFavorite;
import org.ani7.anirec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreFavoriteRepository extends JpaRepository<GenreFavorite, Integer> {

    List<GenreFavorite> findByUser(User user);

    List<GenreFavorite> findByGenreType(GenreType genreType);
}
