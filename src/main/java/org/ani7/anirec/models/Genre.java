package org.ani7.anirec.models;

import javax.persistence.*;

@Entity
@Table(name = "Genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;
    @ManyToOne
    @JoinColumn(name = "animeId")
    private Anime anime;
    @Enumerated(EnumType.STRING)
    private GenreType genreType;

    public enum GenreType {
        KIDS, YURI, SHOUNEN_AI, SAMURAI, DEMENTIA,
        POLICE, YAOI, HORROR, HENTAI, SEINEN, MECHA, SPACE,
        SPORTS, MARTIAL_ARTS, CARS, COMEDY, SCHOOL, MUSIC, SHOUNEN,
        JOSEI, MYSTERY, THRILLER, HAREM, FANTASY, SLICE_OF_LIFE,
        DRAMA, ECCHI, SCI_FI, ACTION, SUPER_POWER, GAME, HISTORICAL,
        ROMANCE, MAGIC, PARODY, VAMPIRE, DEMONS, SUPERNATURAL, SHOUJO,
        ADVENTURE, SHOUJO_AI, PSYCHOLOGICAL, MILITARY
    }

    public Genre() {
    }

    public Genre(int genreId, Anime anime, GenreType genreType) {
        this.genreId = genreId;
        this.anime = anime;
        this.genreType = genreType;
    }

    public Genre(Anime anime, GenreType genreType) {
        this.anime = anime;
        this.genreType = genreType;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public void setGenreType(GenreType genreType) {
        this.genreType = genreType;
    }
}
