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

import java.util.List;
import java.util.Optional;

@Service
public class SnippetsService {

    private final SnippetsRepository repository;

    @Autowired
    public SnippetsService(SnippetsRepository repository) {
        this.repository = repository;
    }

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

    public Optional<Snippets> getSnipByUserName(User user) {
        return repository.findByUserName(user.getUserName());
    }

    public String deleteSnipById(Integer snipId) {
        repository.deleteById(snipId);
        return "Snippets removed!" + snipId;
    }
}