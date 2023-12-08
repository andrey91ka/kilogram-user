package SkillBox.com.users.service;

import SkillBox.com.users.dto.ProfileDto;
import SkillBox.com.users.dto.UserDto;

import java.util.UUID;

public interface ProfileService {

    ProfileDto getProfileByUserId(UUID userId);

    ProfileDto createProfile(ProfileDto profileDto);

    ProfileDto updateProfile(UUID userId, ProfileDto profileDto);

}
