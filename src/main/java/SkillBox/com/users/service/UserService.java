package SkillBox.com.users.service;

import SkillBox.com.users.domain.User;
import SkillBox.com.users.dto.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto findUser(UUID id);

    User getUser(UUID id);

    UserDto updateUser(UUID id, UserDto userDto);

    void delete(UUID id);
}
