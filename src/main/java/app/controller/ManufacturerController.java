package app.controller;

import app.dto.ManufacturerDto;
import app.service.api.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/manufacturers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping
    public ResponseEntity<ManufacturerDto> add(@RequestBody @Valid ManufacturerDto manufacturerDto) {
        manufacturerService.save(manufacturerDto);
        return ResponseEntity.ok(manufacturerDto);
    }

    @GetMapping
    public ResponseEntity<List<ManufacturerDto>> findAll() {
        List<ManufacturerDto> manufacturers = manufacturerService.findAll();
        return ResponseEntity.ok(manufacturers);
    }

}
