package app.repository.api;

import app.entity.IdEntity;

import java.util.List;

public interface Repository<E extends IdEntity> {

    void save(E object);

    E find(String id);

    void update(E oldObject, E newObject);

    void delete(E object);

    List<E> findAll();
}
