package app.service.api;

import app.dto.IdDto;

import java.util.List;

public interface Service<D extends IdDto> {

    void save(D dto);

    D find(String id);

    void update(D dto);

    void delete(String id);

    List<D> findAll();
}
