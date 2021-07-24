package org.ani7.anirec.models;

import javax.persistence.*;

@Entity
@Table(name = "Snippets")
public class Snippets {

    @Id
    @GeneratedValue
    private int snipId;
    private String snippet;
    private String userName;
    private int animeId;

    public Snippets() {
    }

    public Snippets(int snipId, String snippet, String userName, int animeId) {
        this.snipId = snipId;
        this.snippet = snippet;
        this.userName = userName;
        this.animeId = animeId;
    }

    public Snippets(String snippet, String userName, int animeId) {
        this.snippet = snippet;
        this.userName = userName;
        this.animeId = animeId;
    }

    public int getSnipId() {
        return snipId;
    }

    public void setSnipId(int snipId) {
        this.snipId = snipId;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAnimeId() {
        return animeId;
    }

    public void setAnimeId(int animeId) {
        this.animeId = animeId;
    }
}
