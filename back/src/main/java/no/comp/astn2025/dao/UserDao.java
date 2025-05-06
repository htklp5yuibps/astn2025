package no.comp.astn2025.dao;

import no.comp.astn2025.entity.User;

public interface UserDao extends Dao<User> {
    public User readWhereEmail(String email);
}
