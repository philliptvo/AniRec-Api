package org.ani7.anirec.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AnimeFavorites")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class AnimeFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animeFavoriteId;

    @ManyToOne
    @JoinColumn(name = "animeId")
    @JsonBackReference
    private Anime anime;

    @ManyToOne
    @JoinColumn(name = "userName")
    @JsonBackReference
    private User user;

    public AnimeFavorite() {
    }

    public AnimeFavorite(int animeFavoriteId, Anime anime, User user) {
        this.animeFavoriteId = animeFavoriteId;
        this.anime = anime;
        this.user = user;
    }

    public int getAnimeFavoriteId() {
        return animeFavoriteId;
    }

    public void setAnimeFavoriteId(int animeFavoriteId) {
        this.animeFavoriteId = animeFavoriteId;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
