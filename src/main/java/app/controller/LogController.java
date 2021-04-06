package app.controller;

import app.dto.LogDto;
import app.service.api.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/logs", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<LogDto> add(@RequestBody @Valid LogDto logDto) {
        logService.save(logDto);
        return ResponseEntity.ok(logDto);
    }

    @GetMapping
    public ResponseEntity<List<LogDto>> findAll() {
        List<LogDto> logs = logService.findAll();
        return ResponseEntity.ok(logs);
    }

    @PutMapping
    public ResponseEntity<LogDto> update(@RequestBody @Valid LogDto logDto) {
        logService.update(logDto);
        return ResponseEntity.ok(logDto);
    }

    @DeleteMapping(value = "/{logId}")
    public ResponseEntity<LogDto> delete(@PathVariable String logId) {
        logService.delete(logId);
        return ResponseEntity.ok().build();
    }
}
