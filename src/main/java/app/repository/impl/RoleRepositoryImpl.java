package app.repository.impl;

import app.entity.Role;
import app.repository.api.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Repository
public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository {

    @PostConstruct
    public void init() {
        Arrays.stream(Role.RoleType.values())
                .forEach(role -> {
                    Role r = new Role();
                    r.setRoleType(Role.RoleType.valueOf(role.name()));
                    save(r);
                });
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

}
