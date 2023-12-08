package SkillBox.com.users.dto;

import SkillBox.com.users.domain.Gender;
import SkillBox.com.users.domain.StatusUser;
import lombok.Data;

import java.util.Date;

@Data
public class UserWithProfileDto {
    private String username;
    private String email;
    private String password;
    private StatusUser statusUser;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private Gender gender;

    private String biography;

    private String profilePhoto;
}
