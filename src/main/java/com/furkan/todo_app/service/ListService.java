package com.furkan.todo_app.service;

import com.furkan.todo_app.exception.ListNotFoundException;
import com.furkan.todo_app.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListService {
    @Autowired
    private ListRepository repo;

    public List<com.furkan.todo_app.model.List> listAll(){
        return (List<com.furkan.todo_app.model.List>) repo.findAll();
    }

    public void save(com.furkan.todo_app.model.List list) {
        repo.save(list);
        return ;
    }

    public com.furkan.todo_app.model.List get(Integer id) throws ListNotFoundException {
        Optional<com.furkan.todo_app.model.List> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ListNotFoundException("Couldn find any User with ID "+ id);
    }

    public void delete(Integer id) throws ListNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count==0){
            throw new ListNotFoundException("Couldn find any User with ID "+ id);
        }
        repo.deleteById(id);
    }
}
