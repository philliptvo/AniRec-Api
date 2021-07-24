package org.ani7.anirec.controllers;

import org.ani7.anirec.models.Snippets;
import org.ani7.anirec.services.SnippetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SnippetsController {

    @Autowired
    private SnippetsService service;

    @PostMapping("/createSnippet")
    public Snippets addSnippet(@RequestBody Snippets snippet) {
        return service.saveSnip(snippet);
    }

    @PostMapping("/snippets")
    public List<Snippets> addProducts(@RequestBody List<Snippets> snippets) {
        return service.saveSnips(snippets);
    }

    @GetMapping("/snippets")
    public List<Snippets> findAllSnippets() {
        return service.getSnippets();
    }

    @GetMapping("/snippet/{id}")
    public Snippets findSnippetById(@PathVariable int id) {
        return service.getSnipById(id);
    }

    @GetMapping("/snippet/{name}")
    public Snippets findSnippetByUserName(@PathVariable String userName) {
        return service.getSnipByUserName(userName);
    }

    @PutMapping("/snippets")
    public Snippets updateSnippet(@RequestBody Snippets snippet) {
        return service.updateSnippet(snippet);
    }

    @DeleteMapping("/snippets/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteSnipById(id);
    }

}