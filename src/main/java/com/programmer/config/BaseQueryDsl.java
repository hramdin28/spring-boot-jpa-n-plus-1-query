package com.programmer.config;

import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BaseQueryDsl {

    private final EntityManager entityManager;

    public <T> JPAQuery<T> query() {
        return new JPAQuery<>(entityManager);
    }
}
