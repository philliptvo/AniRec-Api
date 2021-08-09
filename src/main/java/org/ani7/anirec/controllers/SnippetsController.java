package org.ani7.anirec.controllers;

import org.ani7.anirec.models.Snippets;
import org.ani7.anirec.payloads.ApiResponse;
import org.ani7.anirec.services.SnippetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/snippets")
public class SnippetsController {

    @Autowired
    private SnippetsService service;

    @GetMapping("")
    public List<Snippets> getAllSnippets(@RequestParam(defaultValue = "1") String pageNum,
                                         @RequestParam(defaultValue = "25") String pageSize) {
        Page<Snippets> page = service.findAllSnippets(Integer.parseInt(pageNum) - 1,
                Integer.parseInt(pageSize));
        return page.getContent();
    }

    @GetMapping("{id}")
    public ResponseEntity<Snippets> getSnippetsById(@PathVariable Integer id) {
        try {
            Snippets snippet = service.getSnipById(id);
            return new ResponseEntity<>(snippet, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Snippets> createSnippet(@RequestBody Snippets snippet) {
        service.saveSnip(snippet);
        return new ResponseEntity<>(snippet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Snippets> updateSnippet(@RequestBody Snippets snippet, @PathVariable Integer id) {
        try {
            Snippets oldSnippets = service.getSnipById(id);
            snippet.setSnipId(id);
            service.saveSnip(snippet);
            return new ResponseEntity<>(snippet, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSnippet(@PathVariable Integer id) {
        try {
            service.deleteSnipById(id);
            return new ResponseEntity<>(new ApiResponse(true, "Snippets deleted successfully"),
                    HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}