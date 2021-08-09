package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Snippets;
import org.ani7.anirec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SnippetsRepository extends JpaRepository<Snippets, Integer> {
    List<Snippets> findByUser(User user);

    List<Snippets> findByAnime(Anime anime);
}
