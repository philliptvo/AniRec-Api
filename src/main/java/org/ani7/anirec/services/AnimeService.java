package org.ani7.anirec.services;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnimeService {

    @Autowired
    private AnimeRepository repository;

    public Page<Anime> findAllAnime(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        return repository.findAll(pageable);
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
