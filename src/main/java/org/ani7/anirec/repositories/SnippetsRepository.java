package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Snippets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SnippetsRepository extends JpaRepository<Snippets,Integer> {
    Optional<Snippets> findByUserName(String userName);
}
