package SkillBox.com.users.dto;

import SkillBox.com.users.domain.StatusUser;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;
    private String password;
    private StatusUser statusUser;
}
