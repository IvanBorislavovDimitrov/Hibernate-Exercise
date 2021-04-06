package app.service.impl;

import app.dto.LogDto;
import app.entity.Log;
import app.repository.api.LogRepositry;
import app.service.api.LogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends AbstractService<Log, LogDto> implements LogService {

    @Autowired
    public LogServiceImpl(LogRepositry logRepositry, ModelMapper modelMapper) {
        super(logRepositry, modelMapper);
    }

    @Override
    protected Class<Log> getEntityClass() {
        return Log.class;
    }

    @Override
    protected Class<LogDto> getDtoClass() {
        return LogDto.class;
    }
}
