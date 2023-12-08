package SkillBox.com.users.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status_user")
    private StatusUser statusUser;

    @CreatedDate
    @Column(name = "date_create")
    private Instant dateCreate = Instant.now();

    @LastModifiedDate
    @Column(name = "date_update")
    private Instant dateUpdate = Instant.now();


}
