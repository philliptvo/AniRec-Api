package org.ani7.anirec.services;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnimeService {

    @Autowired
    private AnimeRepository repository;

    public List<Anime> findAllAnime() {
        return repository.findAll();
    }

    public void saveAnime(Anime anime) {
        repository.save(anime);
    }

    public Anime getAnimeById(Integer animeId) {
        return repository.getById(animeId);
    }

    public void deleteAnimeById(Integer animeId) {
        repository.deleteById(animeId);
    }
}
