package org.ani7.anirec.services;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Snippets;
import org.ani7.anirec.models.User;
import org.ani7.anirec.repositories.SnippetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SnippetsService {

    @Autowired
    private SnippetsRepository repository;

    public Page<Snippets> findAllSnippets(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        return repository.findAll(pageable);
    }

    public Snippets saveSnip(Snippets snippet) {
        return repository.save(snippet);
    }

    public Snippets getSnipById(int snipId) {
        return repository.findById(snipId).orElse(null);
    }

    public List<Snippets> getSnipByUser(User user) {
        return repository.findByUser(user);
    }

    public List<Snippets> getSnipByAnime(Anime anime) {
        return repository.findByAnime(anime);
    }

    public String deleteSnipById(Integer snipId) {
        repository.deleteById(snipId);
        return "Snippets removed!" + snipId;
    }
}