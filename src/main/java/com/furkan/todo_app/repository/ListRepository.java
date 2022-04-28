package com.furkan.todo_app.repository;

import com.furkan.todo_app.model.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List,Integer> {
    public Long countById(Integer id);
}
