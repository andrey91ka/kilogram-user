package SkillBox.com.users.service.Impl;

import SkillBox.com.users.domain.Profile;
import SkillBox.com.users.domain.StatusUser;
import SkillBox.com.users.domain.User;
import SkillBox.com.users.dto.UserDto;
import SkillBox.com.users.mapper.UserMapper;
import SkillBox.com.users.repository.UserRepository;
import SkillBox.com.users.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        return userMapper.toDto(
                userRepository.save(userMapper.toEntity(userDto)));
    }

    @Override
    public UserDto findUser(UUID id) {
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found User with id: " + id));
        return userMapper.toDto(user);
    }

    @Override
    public User getUser(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found User with id: " + id));
    }

    @Override
    public UserDto updateUser(UUID id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found User with id: " + id));
        userMapper.toDto(
                userRepository.save(
                        userMapper.updateFromDto(userDto, user)));
        return null;
    }

    @Override
    public void delete(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found User with id: " + id));
        user.setStatusUser(StatusUser.DELETED);
        userRepository.save(user);
    }




}
