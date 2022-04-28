package com.furkan.todo_app.controller;

import com.furkan.todo_app.model.Item;
import com.furkan.todo_app.model.List;
import com.furkan.todo_app.service.ItemService;
import com.furkan.todo_app.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ListService listService;
    @GetMapping("")
    public String viewHomePage(Model model){
        java.util.List<Item> listLists = itemService.listAll();
        java.util.List<List> lists = listService.listAll();
        model.addAttribute("listLists",listLists);
        model.addAttribute("lists",lists);
        return "index";
    }

    @GetMapping("index")
    public String viewHomePage2(Model model){
        java.util.List<Item> listLists = itemService.listAll();
        java.util.List<List> lists = listService.listAll();
        model.addAttribute("listLists",listLists);
        model.addAttribute("lists",lists);
        return "index";
    }



}
