package app.repository.api;

import app.entity.IdEntity;

import java.util.List;

public interface Repository<E extends IdEntity> {

    void save(E object);

    E find(String id);

    void update(E object);

    void delete(String id);

    List<E> findAll();

    void merge(E object);
}
