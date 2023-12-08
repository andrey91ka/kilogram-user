package SkillBox.com.users.config;

import SkillBox.com.users.mapper.ProfileMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

public class MapperConfig {
    @Bean
    public ProfileMapper profileMapper() {
        return Mappers.getMapper(ProfileMapper.class);
    }
}
