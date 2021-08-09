package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByAnime(Anime anime);

    void deleteAllByAnime(Anime anime);
}
