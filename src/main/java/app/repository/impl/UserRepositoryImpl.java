package app.repository.impl;

import app.entity.User;
import app.repository.api.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
