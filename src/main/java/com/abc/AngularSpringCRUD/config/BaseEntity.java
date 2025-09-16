package com.abc.AngularSpringCRUD.config;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private String createdBy;
    private String updatedBy;
    private Boolean active;

    //Hooks for auto Timestamping

    @PrePersist

    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

//    //soft delete
//    protected void softDelete(){
//        this.deletedAt = LocalDateTime.now();
//    }
//
//    public boolean isDeleted(){
//      return this.deletedAt != null;
//    }

}
