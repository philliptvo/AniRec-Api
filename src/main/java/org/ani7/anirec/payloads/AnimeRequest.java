package org.ani7.anirec.payloads;

import org.ani7.anirec.models.Anime;

import java.util.List;

public class AnimeRequest {
    private Anime anime;
    private List<String> genres;

    public AnimeRequest() {
    }

    public AnimeRequest(Anime anime, List<String> genres) {
        this.anime = anime;
        this.genres = genres;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
