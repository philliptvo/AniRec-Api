package org.ani7.anirec.controllers;

import java.util.NoSuchElementException;
import org.ani7.anirec.models.AnimeFavorite;
import org.ani7.anirec.services.AnimeFavoriteService;
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
@RequestMapping("/api/animeFavorite")
public class AnimeFavoriteController {

    @Autowired
    private AnimeFavoriteService service;

    @GetMapping("/{id}")
    public ResponseEntity<AnimeFavorite> getAnimeFavoriteById(@PathVariable Integer id) {
        try {
            final AnimeFavorite animeFavorite = service.getAnimeFavoriteById(id);
            return new ResponseEntity<>(animeFavorite, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<AnimeFavorite> createAnimeFavorite(@RequestBody AnimeFavorite animeFavorite) {
        service.saveAnimeFavorite(animeFavorite);
        return new ResponseEntity<>(animeFavorite, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimeFavorite> updateAnimeFavoriteById(@RequestBody AnimeFavorite animeFavorite, @PathVariable Integer id) {
        try {
            AnimeFavorite originalAnimeFavorite = service.getAnimeFavoriteById(id);
            service.saveAnimeFavorite(animeFavorite);
            return new ResponseEntity<>(animeFavorite, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AnimeFavorite> deleteAnimeFavoriteById(@PathVariable Integer id) {
        try {
            service.deleteAnimeFavoriteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
