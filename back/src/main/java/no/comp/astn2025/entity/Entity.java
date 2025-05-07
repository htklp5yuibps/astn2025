package no.comp.astn2025.entity;

import java.util.Objects;

public abstract class Entity {
    private long id;
    private EntityStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id && status == entity.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }
}
