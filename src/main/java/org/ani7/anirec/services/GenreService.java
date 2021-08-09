package org.ani7.anirec.services;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Genre;
import org.ani7.anirec.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class GenreService {

    @Autowired
    GenreRepository repository;

    public Set<String> getGenreByAnime(Anime anime) {
        List<Genre> genres = repository.findByAnime(anime);
        return genres.stream().map(genre -> genre.getGenreType().name()).collect(Collectors.toSet());
    }

    public void saveAllGenres(Collection<Genre> genres) {
        repository.saveAll(genres);
    }

    public void removeAllGenresByAnime(Anime anime) {
        repository.deleteAllByAnime(anime);
    }
}
