package com.abc.AngularSpringCRUD.entity;

import com.abc.AngularSpringCRUD.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "users")
@Entity

public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String username;

    @OneToOne(mappedBy = "user",
    cascade = CascadeType.ALL,orphanRemoval = true)
    private Profile profile;

    //helper to link both side
    public void setProfile(Profile profile) {
        this.profile = profile;
        if (profile != null) {
            profile.setUser(this);
        }
    }
}
