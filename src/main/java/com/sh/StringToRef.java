package com.sh;

import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.StdConverter;

public class StringToRef extends StdConverter<String,Reference> {
    @Override
    public Reference convert(String s) {
        return Reference.of(s);
    }
}
