package org.ani7.anirec.payloads;

import org.ani7.anirec.models.Anime;

import java.time.LocalDate;
import java.util.Set;

public class AnimeResponse {

    private int animeId;
    private String title;
    private Anime.AnimeType animeType;
    private LocalDate airedFrom;
    private LocalDate airedTo;
    private String synopsis;
    private int numEpisodes;
    private Set<String> genres;

    public AnimeResponse(int animeId, String title, Anime.AnimeType animeType, LocalDate airedFrom, LocalDate airedTo, String synopsis, int numEpisodes, Set<String> genres) {
        this.animeId = animeId;
        this.title = title;
        this.animeType = animeType;
        this.airedFrom = airedFrom;
        this.airedTo = airedTo;
        this.synopsis = synopsis;
        this.numEpisodes = numEpisodes;
        this.genres = genres;
    }

    public int getAnimeId() {
        return animeId;
    }

    public void setAnimeId(int animeId) {
        this.animeId = animeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Anime.AnimeType getAnimeType() {
        return animeType;
    }

    public void setAnimeType(Anime.AnimeType animeType) {
        this.animeType = animeType;
    }

    public LocalDate getAiredFrom() {
        return airedFrom;
    }

    public void setAiredFrom(LocalDate airedFrom) {
        this.airedFrom = airedFrom;
    }

    public LocalDate getAiredTo() {
        return airedTo;
    }

    public void setAiredTo(LocalDate airedTo) {
        this.airedTo = airedTo;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getNumEpisodes() {
        return numEpisodes;
    }

    public void setNumEpisodes(int numEpisodes) {
        this.numEpisodes = numEpisodes;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }
}
