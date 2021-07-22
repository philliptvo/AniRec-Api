package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Snippets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetsRepository extends
        JpaRepository<Snippets, Integer> {
}
