package org.ani7.anirec.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.ani7.anirec.models.Genre.GenreType;

@Entity
@Table(name = "GenreFavorites")
public class GenreFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreFavoriteId;

    @ManyToOne
    @JoinColumn(name = "userName")
    private User user;

    @Enumerated(EnumType.STRING)
    private GenreType genreType;

    public GenreFavorite() {
    }

    public GenreFavorite(int genreFavoriteId, User user,
        GenreType genreType) {
        this.genreFavoriteId = genreFavoriteId;
        this.user = user;
        this.genreType = genreType;
    }

    public int getGenreFavoriteId() {
        return genreFavoriteId;
    }

    public void setGenreFavoriteId(int genreFavoriteId) {
        this.genreFavoriteId = genreFavoriteId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public void setGenreType(GenreType genreType) {
        this.genreType = genreType;
    }
}
