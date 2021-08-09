package org.ani7.anirec.controllers;

import org.ani7.anirec.models.Anime;
import org.ani7.anirec.models.Genre;
import org.ani7.anirec.payloads.AnimeRequest;
import org.ani7.anirec.payloads.AnimeResponse;
import org.ani7.anirec.payloads.ApiResponse;
import org.ani7.anirec.services.AnimeService;
import org.ani7.anirec.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;
    @Autowired
    private GenreService genreService;

    @GetMapping("")
    public List<Anime> getAllAnime(@RequestParam(defaultValue = "1") String pageNum, @RequestParam(defaultValue = "25") String pageSize) {
        Page<Anime> page = animeService.findAllAnime(Integer.parseInt(pageNum) - 1, Integer.parseInt(pageSize));

        return page.getContent();
    }

    @GetMapping("{id}")
    public ResponseEntity<AnimeResponse> getAnimeById(@PathVariable Integer id) {
        try {
            Anime anime = animeService.getAnimeById(id);
            Set<String> genres = genreService.getGenreByAnime(anime);

            AnimeResponse animeResponse = new AnimeResponse(anime.getAnimeId(), anime.getTitle(), anime.getAnimeType(),
                    anime.getAiredFrom(), anime.getAiredTo(), anime.getSynopsis(), anime.getNumEpisodes(), genres);
            return new ResponseEntity<>(animeResponse, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<AnimeResponse> createAnime(@RequestBody AnimeRequest animeRequest) {
        Anime anime = animeRequest.getAnime();
        Set<Genre> genres = animeRequest.getGenres().stream().map(s -> {
            Genre genre = new Genre();
            genre.setAnime(anime);
            genre.setGenreType(Genre.GenreType.valueOf(s));
            return genre;
        }).collect(Collectors.toSet());

        animeService.saveAnime(animeRequest.getAnime());
        genreService.saveAllGenres(genres);

        AnimeResponse animeResponse = new AnimeResponse(anime.getAnimeId(), anime.getTitle(), anime.getAnimeType(),
                anime.getAiredFrom(), anime.getAiredTo(), anime.getSynopsis(), anime.getNumEpisodes(),
                genres.stream().map(genre -> genre.getGenreType().name()).collect(Collectors.toSet()));
        return new ResponseEntity<>(animeResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimeResponse> updateAnime(@RequestBody AnimeRequest animeRequest, @PathVariable Integer id) {
        try {
            Anime anime = animeRequest.getAnime();
            Set<Genre> genres = animeRequest.getGenres().stream().map(s -> {
                Genre genre = new Genre();
                genre.setAnime(anime);
                genre.setGenreType(Genre.GenreType.valueOf(s));
                return genre;
            }).collect(Collectors.toSet());

            Anime oldAnime = animeService.getAnimeById(id);
            anime.setAnimeId(id);
            animeService.saveAnime(anime);

            // Remove all previous genre associations and create new ones
            genreService.removeAllGenresByAnime(anime);
            genreService.saveAllGenres(genres);

            AnimeResponse animeResponse = new AnimeResponse(anime.getAnimeId(), anime.getTitle(), anime.getAnimeType(),
                    anime.getAiredFrom(), anime.getAiredTo(), anime.getSynopsis(), anime.getNumEpisodes(),
                    genres.stream().map(genre -> genre.getGenreType().name()).collect(Collectors.toSet()));
            return new ResponseEntity<>(animeResponse, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnime(@PathVariable Integer id) {
        try {
            Anime animeToDelete = animeService.getAnimeById(id);
            genreService.removeAllGenresByAnime(animeToDelete);
            animeService.deleteAnimeById(id);
            return new ResponseEntity<>(new ApiResponse(true, "Anime deleted successfully"), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
