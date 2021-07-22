package org.ani7.anirec.services;

import org.ani7.anirec.models.Snippets;
import org.ani7.anirec.repositories.SnippetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnippetsService {

    private final SnippetsRepository snippetsRepo;

    @Autowired
    public SnippetsService(SnippetsRepository snippetsRepo) {
        this.snippetsRepo = snippetsRepo;
    }

    public List<Snippets> findAllSnippets() {
        return snippetsRepo.findAll();
    }

    public void saveSnip(Snippets snip) {
        snippetsRepo.save(snip);
    }

    public Snippets getSnipById(Integer snipId) {
        return snippetsRepo.getById(snipId);
    }

    public void deleteSnipById(Integer snipId) {
        snippetsRepo.deleteById(snipId);
    }

}
