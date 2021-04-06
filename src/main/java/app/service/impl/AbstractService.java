package app.service.impl;

import app.dto.IdDto;
import app.entity.IdEntity;
import app.repository.api.Repository;
import app.service.api.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractService<E extends IdEntity, D extends IdDto> implements Service<D> {

    protected final ModelMapper modelMapper;
    private final Repository<E> repository;

    protected AbstractService(Repository<E> repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(D dto) {
        E entity = modelMapper.map(dto, getEntityClass());
        repository.save(entity);
    }

    @Override
    public D find(String id) {
        E entity = repository.find(id);
        return modelMapper.map(entity, getDtoClass());
    }

    @Override
    public void update(D dto) {
        E entity = modelMapper.map(dto, getEntityClass());
        repository.update(entity);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public List<D> findAll() {
        return convertEntityListToDto(repository.findAll());
    }

    protected List<D> convertEntityListToDto(List<E> entities) {
        return entities.stream()
                .map(entity -> modelMapper.map(entity, getDtoClass()))
                .collect(Collectors.toList());
    }

    protected abstract Class<E> getEntityClass();

    protected abstract Class<D> getDtoClass();

}
