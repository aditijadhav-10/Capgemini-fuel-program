package com.example.Spring12.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersist()
    {
        createAt=LocalDateTime.now();
        updateAt=LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate()
    {
        updateAt=LocalDateTime.now();
    }

}
