package SkillBox.com.users.service;

import SkillBox.com.users.domain.UserSubscriber;
import SkillBox.com.users.dto.SubscriverListDto;
import SkillBox.com.users.dto.UserSubscriberDto;

import java.util.List;
import java.util.UUID;

public interface SubscribersService {

    UserSubscriberDto addSubscriber(UserSubscriberDto userSubscriber);

    void deleteSubscriber(UUID userId, UUID friendId);

    SubscriverListDto getSubscribers(UUID userId);

    SubscriverListDto getSubscriptions(UUID friendId);

}
