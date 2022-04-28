package com.furkan.todo_app.controller;

import com.furkan.todo_app.exception.ListNotFoundException;
import com.furkan.todo_app.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ListController {
    @Autowired
    private ListService listService;

    // List leri listeliyorum .
    @GetMapping("/lists")
    public String showList(Model model){
        List<com.furkan.todo_app.model.List> listLists = listService.listAll();
        model.addAttribute("listLists",listLists);
        return "index";
    }

    // List formu gönderiyorum .
    @GetMapping("/lists/new")
    public String showNewForm(Model model){
        model.addAttribute("list",new com.furkan.todo_app.model.List());
        model.addAttribute("pageTitle","Add New List");
        return "list_form";
    }

    //  POST metodu ile List i kayıt ediyorum.
    @PostMapping("/lists/save")
    public String saveList(com.furkan.todo_app.model.List list, RedirectAttributes ra){
        listService.save(list);
        ra.addFlashAttribute("message","The List has been saved succesfuly");
        return ("redirect:/");
    }

    // List Id si ile forma kayıtlı bilgileri gösteriyorum .
    @GetMapping("/lists/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            com.furkan.todo_app.model.List list = listService.get(id);
            model.addAttribute("list",list);
            model.addAttribute("pageTitle","Edit List ");

            return "list_form";
        } catch (ListNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/";
        }
    }

    // List Id si ile silme işlmei yapıyorum
    @GetMapping("/lists/delete/{id}")
    public String deleteList(@PathVariable("id") Integer id,RedirectAttributes ra){
        try {
            listService.delete(id);
            ra.addFlashAttribute("message","The List ID "+id+" has been deleted.");

        } catch (ListNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/";
    }
}
