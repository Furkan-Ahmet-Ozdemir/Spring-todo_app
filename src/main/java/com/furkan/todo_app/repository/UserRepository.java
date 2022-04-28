package com.furkan.todo_app.repository;

import com.furkan.todo_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public Long countById(Integer id);
}
