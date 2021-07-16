package org.ani7.anirec.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Anime")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animeId;

    private String title;

    @Enumerated(EnumType.STRING)
    private AnimeType animeType;

    private LocalDate airedFrom;

    private LocalDate airedTo;

    private String synopsis;

    private int numEpisodes;

    public enum AnimeType {
        TV, MOVIE, OVA
    }

    public Anime() {
    }

    public Anime(int animeId, String title, AnimeType animeType, LocalDate airedFrom, LocalDate airedTo, String synopsis, int numEpisodes) {
        this.animeId = animeId;
        this.title = title;
        this.animeType = animeType;
        this.airedFrom = airedFrom;
        this.airedTo = airedTo;
        this.synopsis = synopsis;
        this.numEpisodes = numEpisodes;
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

    public AnimeType getAnimeType() {
        return animeType;
    }

    public void setAnimeType(AnimeType animeType) {
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
}
