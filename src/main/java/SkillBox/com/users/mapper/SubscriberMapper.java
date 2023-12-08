package SkillBox.com.users.mapper;

import SkillBox.com.users.domain.User;
import SkillBox.com.users.domain.UserSubscriber;
import SkillBox.com.users.dto.SubscriverListDto;
import SkillBox.com.users.dto.UserSubscriberDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper
public interface SubscriberMapper {

    @Mapping(target = "user", source = "user.id")
    @Mapping(target = "friend", source = "friend.id")
    UserSubscriberDto userSubscriberToUserSubscriberDto(UserSubscriber userSubscriber);




//    @Mapping(target = "userId", source = "user")
//    @Mapping(target = "friends", source = "friends")
//    SubscriverListDto ToSubscriverListDto(UserSubscriber userSubscriber);
//
//
//    default UUID mapToUserId(User user) {
//        return user.getId();
//    }
//
//    default List<UUID> mapToFriends(Set<User>friends) {
//        return friends.stream()
//                .map(User::getId)
//                .collect(Collectors.toList());
//    }
}

