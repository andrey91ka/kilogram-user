package SkillBox.com.users.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
public class SubscriverListDto {
    private UUID userId;
    private List<UUID> friends;
}
