package com.sh;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(converter = RefToString.class)
@JsonDeserialize(converter = StringToRef.class)
public record Reference(String entity, String ref) {
    public static Reference of(String entity, String ref) {
        return new Reference(entity, ref);
    }

    public static Reference of(String s) {
        final var idx = s.indexOf('/');
        return new Reference(s.substring(0, idx), s.substring(idx + 1));
    }

    public String reference() {
        return entity + '/' + ref;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "entity='" + entity + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}
