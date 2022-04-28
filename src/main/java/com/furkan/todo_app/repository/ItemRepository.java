package com.furkan.todo_app.repository;

import com.furkan.todo_app.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
    public Long countById(Integer id);
}
