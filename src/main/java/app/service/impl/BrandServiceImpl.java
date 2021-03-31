package app.service.impl;

import app.dto.BrandDto;
import app.entity.Brand;
import app.repository.api.BrandRepository;
import app.service.api.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends AbstractService<Brand, BrandDto> implements BrandService {

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        super(brandRepository, modelMapper);
    }

    @Override
    protected Class<Brand> getEntityClass() {
        return Brand.class;
    }

    @Override
    protected Class<BrandDto> getDtoClass() {
        return BrandDto.class;
    }
}
