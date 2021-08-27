package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {

    @Query("SELECT a FROM Anime a WHERE CONCAT(a.title, ' ', a.synopsis) LIKE %?1%")
    public Page<Anime> search(String keyword, Pageable pageable);
}
