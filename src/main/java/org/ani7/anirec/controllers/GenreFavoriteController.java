package org.ani7.anirec.controllers;

import java.util.NoSuchElementException;
import org.ani7.anirec.models.GenreFavorite;
import org.ani7.anirec.services.GenreFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genreFavorite")
public class GenreFavoriteController {

    @Autowired
    private GenreFavoriteService service;

    @GetMapping("/{id}")
    public ResponseEntity<GenreFavorite> getGenreFavoriteById(@PathVariable Integer id) {
        try {
            final GenreFavorite genreFavorite = service.getGenreFavoriteById(id);
            return new ResponseEntity<>(genreFavorite, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<GenreFavorite> createGenreFavorite(@RequestBody GenreFavorite genreFavorite) {
        service.saveGenreFavorite(genreFavorite);
        return new ResponseEntity<>(genreFavorite, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreFavorite> updateGenreFavoriteById(@RequestBody GenreFavorite genreFavorite, @PathVariable Integer id) {
        try {
            GenreFavorite originalGenreFavorite = service.getGenreFavoriteById(id);
            service.saveGenreFavorite(genreFavorite);
            return new ResponseEntity<>(genreFavorite, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenreFavorite> deleteGenreFavoriteById(@PathVariable Integer id) {
        try {
            service.deleteGenreFavoriteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
