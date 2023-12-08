package SkillBox.com.users.mapper;

import SkillBox.com.users.domain.User;
import SkillBox.com.users.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    User updateFromDto(UserDto userDto, @MappingTarget User user);
}
