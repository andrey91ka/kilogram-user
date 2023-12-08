package SkillBox.com.users.repository;

import SkillBox.com.users.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {

    Profile findByUserId(UUID userId);
}
