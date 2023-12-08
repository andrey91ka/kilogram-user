package SkillBox.com.users.dto;

import SkillBox.com.users.domain.FriendshipStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class UserSubscriberDto {
    private UUID user;
    private UUID friend;
}
