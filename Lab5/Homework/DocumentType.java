package org.example;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum DocumentType {
    BOOK, PAPER, ARTICLE;

    @JsonValue
    public String toString() {
        return super.toString();
    }
    @JsonCreator
    public static DocumentType fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Document type cannot be null");
        }

        for (DocumentType documentType : DocumentType.values()) {
            if (documentType.name().equalsIgnoreCase(value.trim())) {
                return documentType;
            }
        }

        throw new IllegalArgumentException("No document type found for the provided value: " + value);
    }

}
