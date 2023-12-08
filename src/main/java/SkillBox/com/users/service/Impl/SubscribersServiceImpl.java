package SkillBox.com.users.service.Impl;


import SkillBox.com.users.domain.FriendshipStatus;
import SkillBox.com.users.domain.User;
import SkillBox.com.users.domain.UserSubscriber;
import SkillBox.com.users.dto.SubscriverListDto;
import SkillBox.com.users.dto.UserSubscriberDto;
import SkillBox.com.users.mapper.SubscriberMapper;
import SkillBox.com.users.repository.UserSubscribersRepository;
import SkillBox.com.users.service.SubscribersService;
import SkillBox.com.users.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class SubscribersServiceImpl implements SubscribersService {

    private final UserSubscribersRepository userSubscribersRepository;
    private final UserService userService;
    private final SubscriberMapper subscriberMapper;

    @Override
    public UserSubscriberDto addSubscriber(UserSubscriberDto userSubscriberDto) {
        User user = userService.getUser(userSubscriberDto.getUser());
        User friend = userService.getUser(userSubscriberDto.getFriend());

        UserSubscriber userSubscriber = new UserSubscriber();
        userSubscriber.setUser(user);
        userSubscriber.setFriend(friend);
        userSubscriber.setFriendshipStatus(FriendshipStatus.SUBSCRIBER);
        return subscriberMapper.userSubscriberToUserSubscriberDto(userSubscribersRepository.save(userSubscriber));
    }

    @Override
    public void deleteSubscriber(UUID userId, UUID friendId) {
        userSubscribersRepository.findByUserIdAndFriendId(userId, friendId)
                .ifPresentOrElse(userSubscribersRepository::delete, () -> {
                    throw new EntityNotFoundException("Subscriber not found");});
    }

    @Override
    public SubscriverListDto getSubscribers(UUID userId) {
        List<UUID> userSubscribers = userSubscribersRepository.findAllByUserId(userId)
                .stream().map(userSubscriber -> userSubscriber.getFriend().getId()).toList();
        SubscriverListDto subscriverListDto = new SubscriverListDto();
        subscriverListDto.setUserId(userId);
        subscriverListDto.setFriends(userSubscribers);
        return subscriverListDto;
    }

    @Override
    public SubscriverListDto getSubscriptions(UUID friendId) {
        List<UUID> userSubscribers = userSubscribersRepository.findAllByFriendId(friendId)
                .stream().map(userSubscriber -> userSubscriber.getUser().getId()).toList();
        SubscriverListDto subscriverListDto = new SubscriverListDto();
        subscriverListDto.setUserId(friendId);
        subscriverListDto.setFriends(userSubscribers);
        return subscriverListDto;
    }


}
