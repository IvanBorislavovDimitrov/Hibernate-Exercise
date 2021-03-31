package app.service.impl;

import app.dto.UserDto;
import app.entity.Role;
import app.entity.User;
import app.repository.api.RoleRepository;
import app.repository.api.UserRepository;
import app.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractService<User, UserDto> implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository) {
        super(userRepository, modelMapper);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        Role role = determineUserRole();
        role.getUsers().add(user);
        user.setRoles(List.of(role));
        userRepository.merge(user);
    }

    private Role determineUserRole() {
        if (!userRepository.findAll().isEmpty()) {
            return roleRepository.findByRoleType(Role.RoleType.ADMIN);
        }
        return roleRepository.findByRoleType(Role.RoleType.USER);
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    protected Class<UserDto> getDtoClass() {
        return UserDto.class;
    }
}
