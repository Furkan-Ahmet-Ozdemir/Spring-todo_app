package com.furkan.todo_app.model;

import javax.persistence.*;

@Table(name = "lists")
@Entity
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 45)
    private String listName;

    public List() {
    }

    public List(Integer id) {
        this.id = id;
    }

    public List(Integer id, String listName) {
        this.id = id;
        this.listName = listName;
    }

    public List(String listName) {
        this.listName = listName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}
