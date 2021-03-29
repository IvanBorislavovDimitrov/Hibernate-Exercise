package app.service.impl;

import app.dto.UserDto;
import app.entity.User;
import app.repository.api.UserRepository;
import app.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, UserDto> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        super(userRepository, modelMapper);
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
