package com.furkan.todo_app.service;

import com.furkan.todo_app.exception.ItemNotFoundException;
import com.furkan.todo_app.model.Item;
import com.furkan.todo_app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repo;

    public java.util.List<Item> listAll(){
        return (java.util.List<Item>) repo.findAll();
    }

    public void save(Item item) {
        repo.save(item);
        return ;
    }

    public Item get(Integer id) throws ItemNotFoundException {
        Optional<Item> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ItemNotFoundException("Couldn find any User with ID "+ id);
    }

    public void delete(Integer id) throws ItemNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count==0){
            throw new ItemNotFoundException("Couldn find any User with ID "+ id);
        }
        repo.deleteById(id);
    }
}
