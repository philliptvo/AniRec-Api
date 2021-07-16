package org.ani7.anirec.models;

import com.fasterxml.jackson.annotation.*;
import org.ani7.anirec.models.enums.AnimeType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Anime")
public class Anime {

    private int animeId;
    private String title;
    private AnimeType animeType;
    private Date airedFrom;
    private Date airedTo;
    private String synopsis;
    private int numEpisodes;

    public Anime() {
    }

    public Anime(int animeId, String title, AnimeType animeType, Date airedFrom, Date airedTo, String synopsis, int numEpisodes) {
        this.animeId = animeId;
        this.title = title;
        this.animeType = animeType;
        this.airedFrom = airedFrom;
        this.airedTo = airedTo;
        this.synopsis = synopsis;
        this.numEpisodes = numEpisodes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Date getAiredFrom() {
        return airedFrom;
    }

    public void setAiredFrom(Date airedFrom) {
        this.airedFrom = airedFrom;
    }

    public Date getAiredTo() {
        return airedTo;
    }

    public void setAiredTo(Date airedTo) {
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
