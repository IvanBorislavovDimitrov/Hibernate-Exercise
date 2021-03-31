package app.service.impl;

import app.dto.RoleDto;
import app.entity.Role;
import app.repository.api.RoleRepository;
import app.service.api.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractService<Role, RoleDto> implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        super(roleRepository, modelMapper);
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto findByRoleType(String roleType) {
        Role role = roleRepository.findByRoleType(Role.RoleType.valueOf(roleType));
        return modelMapper.map(role, RoleDto.class);
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }

    @Override
    protected Class<RoleDto> getDtoClass() {
        return RoleDto.class;
    }

}
