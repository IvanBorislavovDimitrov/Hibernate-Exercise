package app.service.impl;

import app.dto.ManufacturerDto;
import app.entity.Manufacturer;
import app.repository.api.ManufacturerRepository;
import app.service.api.ManufacturerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl extends AbstractService<Manufacturer, ManufacturerDto> implements ManufacturerService {

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ModelMapper modelMapper) {
        super(manufacturerRepository, modelMapper);
    }

    @Override
    protected Class<Manufacturer> getEntityClass() {
        return Manufacturer.class;
    }

    @Override
    protected Class<ManufacturerDto> getDtoClass() {
        return ManufacturerDto.class;
    }
}
