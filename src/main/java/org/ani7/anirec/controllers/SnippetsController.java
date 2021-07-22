package org.ani7.anirec.controllers;

import org.ani7.anirec.models.Snippets;
import org.ani7.anirec.services.SnippetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/snippets")
public class SnippetsController {

    private SnippetsService services;

    @Autowired
    public SnippetsController(SnippetsService snippetsServices) {
        this.services = snippetsServices;
    }

    @GetMapping("/snippets")
    public List<Snippets> getSnippets() {
        return services.findAllSnippets();
    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<Snippets> getSnipById(@PathVariable Integer id) {
        try {
            Snippets snippets = services.getSnipById(id);
            return new ResponseEntity<>(snippets, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/snippets")
    public ResponseEntity<Snippets> createSnip(Snippets snip) {
        services.saveSnip(snip);
        return new ResponseEntity<>(snip, HttpStatus.OK);
    }


    @DeleteMapping("/snippets/{id}")
    public void deleteSnip(@PathVariable Integer id) {
        services.deleteSnipById(id);
    }

}
