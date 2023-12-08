package SkillBox.com.users.repository;

import SkillBox.com.users.domain.UserSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

public interface UserSubscribersRepository extends JpaRepository<UserSubscriber, UUID> {

    Optional<UserSubscriber> findByUserIdAndFriendId(UUID userId, UUID friendId);

    List<UserSubscriber> findAllByUserId(UUID userId);

    List<UserSubscriber> findAllByFriendId(UUID friendId);
}
