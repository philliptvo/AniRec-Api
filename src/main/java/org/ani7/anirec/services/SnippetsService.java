package org.ani7.anirec.services;

import org.ani7.anirec.models.Snippets;
import org.ani7.anirec.repositories.SnippetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnippetsService {

    private final SnippetsRepository repository;

    @Autowired
    public SnippetsService(SnippetsRepository repository) {
        this.repository = repository;
    }

    public Snippets saveSnip(Snippets snippet) {
        return repository.save(snippet);
    }

    public List<Snippets> saveSnips(List<Snippets> snippets) {
        return repository.saveAll(snippets);
    }

    public List<Snippets> getSnippets() {
        return repository.findAll();
    }

    public Snippets getSnipById(int snipId) {
        return repository.findById(snipId).orElse(null);
    }

    public Snippets getSnipByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    public String deleteSnipById(Integer snipId) {
        repository.deleteById(snipId);
        return "Snippets removed!" + snipId;
    }

    public Snippets updateSnippet(Snippets snippet) {
        Snippets existingSnippet = repository.findById(snippet.getSnipId()).orElse(null);
        existingSnippet.setSnippet(existingSnippet.getSnippet());
        existingSnippet.setUserName(existingSnippet.getUserName());
        existingSnippet.setAnimeId(existingSnippet.getAnimeId());
        return repository.save(existingSnippet);
    }

}