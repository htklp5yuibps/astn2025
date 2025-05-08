package no.comp.astn2025.command;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface JSONMapper {
    public default String toStringFromObject(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }
}
