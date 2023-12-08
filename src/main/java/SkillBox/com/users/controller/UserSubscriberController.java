package SkillBox.com.users.controller;

import SkillBox.com.users.domain.UserSubscriber;
import SkillBox.com.users.dto.SubscriverListDto;
import SkillBox.com.users.dto.UserSubscriberDto;
import SkillBox.com.users.service.SubscribersService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/friends")
public class UserSubscriberController {

    private final SubscribersService subscribersService;

    public UserSubscriberController(SubscribersService subscribersService) {
        this.subscribersService = subscribersService;
    }

    @PostMapping("/add")
    public UserSubscriberDto addSubscriber(@RequestBody  UserSubscriberDto userSubscriber) {
        return subscribersService.addSubscriber(userSubscriber);
    }

    @DeleteMapping("/delete")
    public void removeSubscriber(@RequestParam UUID userId, @RequestParam UUID friendId) {
        subscribersService.deleteSubscriber(userId, friendId);
    }

    @GetMapping("/user/{userId}")
    public SubscriverListDto getSubscribers(@PathVariable UUID userId) {
        return subscribersService.getSubscribers(userId);
    }

    @GetMapping("/user/{userId}/subscriptions")
    public SubscriverListDto getSubscriptions(@PathVariable UUID friend) {
        return subscribersService.getSubscriptions(friend);
    }
}
