package com.example.spring.adaptor.out.persistence.repository;

import com.example.spring.adaptor.out.persistence.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {
}
