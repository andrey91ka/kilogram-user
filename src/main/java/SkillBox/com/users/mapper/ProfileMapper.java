package SkillBox.com.users.mapper;

import SkillBox.com.users.domain.Profile;
import SkillBox.com.users.dto.ProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper
public interface ProfileMapper {
    ProfileDto toDto(Profile profile);

    Profile toEntity(ProfileDto profileDto);

    Profile updateFromDto(ProfileDto profileDto, @MappingTarget Profile profile);
}
