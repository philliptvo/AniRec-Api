package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {

}
