package SkillBox.com.users.service.Impl;

import SkillBox.com.users.domain.Profile;
import SkillBox.com.users.dto.ProfileDto;
import SkillBox.com.users.mapper.ProfileMapper;
import SkillBox.com.users.repository.ProfileRepository;
import SkillBox.com.users.service.ProfileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    @Override
    public ProfileDto getProfileByUserId(UUID userId) {
        return profileMapper.toDto(
                profileRepository.findByUserId(userId));
    }

    @Override
    public ProfileDto createProfile(ProfileDto profileDto) {
        return profileMapper.toDto(
                profileRepository.save(
                        profileMapper.toEntity(profileDto)));
    }

    @Override
    public ProfileDto updateProfile(UUID id, ProfileDto profileDto) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found profile with id: " + id));
        return profileMapper.toDto(
                profileRepository.save(
                        profileMapper.updateFromDto(profileDto, profile)));
    }
}
