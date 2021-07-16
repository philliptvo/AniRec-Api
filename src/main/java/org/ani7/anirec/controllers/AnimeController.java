package org.ani7.anirec.controllers;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class AnimeController {

    @Autowired
    private AnimeService service;

    @GetMapping("/anime")
    public List<Anime> getAllAnime() {
        return service.findAllAnime();
    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<Anime> getAnimeById(@PathVariable Integer id) {
        try {
            Anime anime = service.getAnimeById(id);
            return new ResponseEntity<>(anime, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/anime")
    public ResponseEntity<Anime> createAnime(Anime anime) {
        service.saveAnime(anime);
        return new ResponseEntity<>(anime, HttpStatus.OK);
    }

    @PutMapping("/anime/{id}")
    public ResponseEntity<Anime> updateAnime(Anime anime, @PathVariable Integer id) {
        try {
            Anime oldAnime = service.getAnimeById(id);
            anime.setAnimeId(id);
            service.saveAnime(anime);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/anime/{id}")
    public void deleteAnime(@PathVariable Integer id) {
        service.deleteAnimeById(id);
    }
}
