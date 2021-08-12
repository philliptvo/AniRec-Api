package org.ani7.anirec.services;

import org.ani7.anirec.models.Characters;
import org.ani7.anirec.repositories.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class CharactersService {

    @Autowired
    private CharactersRepository repository;

    public Page<Characters> findAllCharacters(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return repository.findAll(pageable);
    }
    public void saveCharacter(Characters characters) {
        repository.save(characters);
    }

    public Characters getCharactersById(Integer characterId) {
        return repository.getById(characterId);
    }

    public Optional<Characters> getCharactersByName(String cName) {
        return repository.findCharacterByCharacterName(cName);
    }

    public void deleteCharactersById(Integer characterId) {
        repository.deleteById(characterId);
    }
}