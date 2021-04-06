package app.repository.impl;

import app.entity.Log;
import app.repository.api.LogRepositry;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepositoryImpl extends AbstractRepository<Log> implements LogRepositry {

    @Override
    protected Class<Log> getEntityClass() {
        return Log.class;
    }
}
