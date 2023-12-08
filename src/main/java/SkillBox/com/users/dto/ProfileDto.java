package SkillBox.com.users.dto;

import SkillBox.com.users.domain.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class ProfileDto {

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private Gender gender;

    private String biography;

    private String profilePhoto;
}
