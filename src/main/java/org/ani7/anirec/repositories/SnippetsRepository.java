package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Snippets;
import org.ani7.anirec.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SnippetsRepository extends JpaRepository<Snippets, Integer> {
    List<Snippets> findByUser(User user);

    List<Snippets> findByAnime(Anime anime);

    @Query("SELECT s FROM Snippets s WHERE CONCAT(s.anime.title, ' ', s.snippet, ' ', s.user.userName) LIKE %?1%")
    Page<Snippets> search(String keywords, Pageable page);
}
