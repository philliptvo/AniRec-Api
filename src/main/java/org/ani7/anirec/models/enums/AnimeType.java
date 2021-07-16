package org.ani7.anirec.models.enums;

public enum AnimeType {
    TV("TV Show"), MOVIE("Movie"), OVA("OVA");

    private String value;

    AnimeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}