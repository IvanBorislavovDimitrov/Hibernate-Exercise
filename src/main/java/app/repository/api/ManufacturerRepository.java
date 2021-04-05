package app.repository.api;

import app.entity.Manufacturer;

public interface ManufacturerRepository extends Repository<Manufacturer> {

    Manufacturer findByName(String name);

}
