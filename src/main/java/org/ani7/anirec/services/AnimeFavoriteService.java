package org.ani7.anirec.services;

import java.util.List;
import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.AnimeFavorite;
import org.ani7.anirec.models.User;
import org.ani7.anirec.repositories.AnimeFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnimeFavoriteService {

    @Autowired
    private AnimeFavoriteRepository repository;

    public void saveAnimeFavorite(AnimeFavorite animeFavorite) {
        repository.save(animeFavorite);
    }

    public AnimeFavorite getAnimeFavoriteById(int animeFavoriteId) {
        return repository.getById(animeFavoriteId);
    }

    public List<AnimeFavorite> getAnimeFavoritesByUser(User user) {
        return repository.findByUser(user);
    }

    public List<AnimeFavorite> getAnimeFavoriteByAnime(Anime anime) {
        return repository.findByAnime(anime);
    }

    public void deleteAnimeFavoriteById(int animeFavoriteId) {
        repository.deleteById(animeFavoriteId);
    }
}
