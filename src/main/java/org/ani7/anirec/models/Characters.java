package org.ani7.anirec.models;

import javax.persistence.*;

@Entity
@Table(name = "Characters")
public class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterId;
    @ManyToOne
    @JoinColumn(name = "AnimeId")
    private Anime anime;
    private String characterName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String description;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    private String image;
    public enum Gender {
        NONBINARY, MALE, FEMALE
    }
    public enum RoleType {
        SUPPORTING, MAIN
    }

    public Characters() {

    }

    public Characters(int characterId, Anime anime, String characterName,
                      Gender gender, String description, RoleType roleType, String image) {
        this.characterId = characterId;
        this.anime = anime;
        this.characterName = characterName;
        this.gender = gender;
        this.description = description;
        this.roleType = roleType;
        this.image = image;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
