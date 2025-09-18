package com.abc.AngularSpringCRUD.entity;

import com.abc.AngularSpringCRUD.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "profiles")
@Entity
public class Profile extends BaseEntity {
    private String first_name;
    private String last_name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}