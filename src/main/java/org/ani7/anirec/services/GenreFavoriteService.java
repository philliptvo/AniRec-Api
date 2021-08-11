package org.ani7.anirec.services;

import java.util.List;
import org.ani7.anirec.models.Genre.GenreType;
import org.ani7.anirec.models.GenreFavorite;
import org.ani7.anirec.models.User;
import org.ani7.anirec.repositories.GenreFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GenreFavoriteService {

    @Autowired
    private GenreFavoriteRepository repository;

    public void saveGenreFavorite(GenreFavorite genreFavorite) {
        repository.save(genreFavorite);
    }

    public GenreFavorite getGenreFavoriteById(int genreFavoriteId) {
        return repository.getById(genreFavoriteId);
    }

    public List<GenreFavorite> getGenreFavoritesByUser(User user) {
        return repository.findByUser(user);
    }

    public List<GenreFavorite> getGenreFavoriteByGenreType(GenreType genreType) {
        return repository.findByGenreType(genreType);
    }

    public void deleteGenreFavoriteById(int genreFavoriteId) {
        repository.deleteById(genreFavoriteId);
    }
}
