package SkillBox.com.users.controller;

import SkillBox.com.users.dto.ProfileDto;
import SkillBox.com.users.service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{userId}")
    public ProfileDto getProfileByUserId(@PathVariable UUID userId) {
        return profileService.getProfileByUserId(userId);
    }

    @PostMapping("/create")
    public ProfileDto createProfile(@RequestBody ProfileDto profileDto) {
        return profileService.createProfile(profileDto);
    }

    @PutMapping("/{userId}")
    public ProfileDto updateProfile(@PathVariable UUID id, @RequestBody ProfileDto profileDto) {
        return profileService.updateProfile(id, profileDto);
    }

}
