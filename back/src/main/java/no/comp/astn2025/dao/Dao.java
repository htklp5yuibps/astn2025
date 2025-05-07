package no.comp.astn2025.dao;

import no.comp.astn2025.entity.Entity;

import java.util.List;

public interface Dao <T extends Entity> {
    void create(T type);
    List<T> readAll();
    T read(long id);
    void update(T type);
    void delete(T type);
}
