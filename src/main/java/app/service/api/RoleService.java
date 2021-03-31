package app.service.api;

import app.dto.RoleDto;

public interface RoleService extends Service<RoleDto> {

    RoleDto findByRoleType(String roleType);
}
