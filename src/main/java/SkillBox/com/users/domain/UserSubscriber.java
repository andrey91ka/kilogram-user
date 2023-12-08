package SkillBox.com.users.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_subscriber")
public class UserSubscriber {
    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    private User friend;

    @Column(name = "friendship_status")
    private FriendshipStatus friendshipStatus;

    @CreatedDate
    @Column(name = "date_create", updatable = false)
    private Instant dateCreate = Instant.now();

    @LastModifiedDate
    @Column(name = "date_update")
        private Instant dateUpdate = Instant.now();
    }
