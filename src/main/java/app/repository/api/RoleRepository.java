package app.repository.api;

import app.entity.Role;

public interface RoleRepository extends Repository<Role> {

    Role findByRoleType(Role.RoleType roleType);
}
