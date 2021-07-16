package org.ani7.anirec.models.enums;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class AnimeTypeConverter implements AttributeConverter<AnimeType, String> {

    @Override
    public String convertToDatabaseColumn(AnimeType animeType) {
        if (animeType == null)
            return null;

        return animeType.getValue();
    }

    @Override
    public AnimeType convertToEntityAttribute(String value) {
        if (value == null)
            return null;

        return Stream.of(AnimeType.values())
                .filter(t -> t.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
