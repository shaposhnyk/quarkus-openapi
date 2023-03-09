package com.sh;

import com.fasterxml.jackson.databind.util.StdConverter;

public class RefToString extends StdConverter<Reference, String> {
    @Override
    public String convert(Reference reference) {
        return reference.reference();
    }
}
