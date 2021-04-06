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

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        super(brandRepository, modelMapper);
        this.brandRepository = brandRepository;
    }

    @Override
    public void update(BrandDto dto) {
        Brand newBrand = modelMapper.map(dto, getEntityClass());
        Brand oldBrand = brandRepository.find(dto.getId());
        newBrand.setProducts(oldBrand.getProducts());
        brandRepository.update(newBrand);
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
