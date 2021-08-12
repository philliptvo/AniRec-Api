package org.ani7.anirec.repositories;

import org.ani7.anirec.models.Characters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharactersRepository extends JpaRepository<Characters, Integer> {

    public Optional<Characters> findCharacterByCharacterName(String cName);

}

