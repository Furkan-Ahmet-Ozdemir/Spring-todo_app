package com.furkan.todo_app.model;

import javax.persistence.*;

@Table(name = "items")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 45)
    private String itemName;

    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "list_id")
    private List list;


    public Item() {

    }

    public Item(Integer id, String itemName, String description, List list) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.list = list;
    }

    public Item(Item item) {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public List getUser(){
        return  list;
    }

    public void setUser(List list){
        this.list = list;
    }
}
