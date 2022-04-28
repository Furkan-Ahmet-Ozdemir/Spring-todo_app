package com.furkan.todo_app.controller;

import com.furkan.todo_app.exception.ItemNotFoundException;
import com.furkan.todo_app.model.Item;
import com.furkan.todo_app.service.ItemService;
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
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ListService listService;

    // Item ları listeliyorum .
    @GetMapping("/items")
    public String showItemList(Model model){
        List<Item> listItems = itemService.listAll();
        model.addAttribute("listItems",listItems);
        return "index";
    }

    // User ları listeye atıp yeni Item formunda gösteriyorum .
    @GetMapping("/items/new")
    public String showItemNewForm(Model model){
        List<com.furkan.todo_app.model.List> listLists = listService.listAll();
        if (listLists.isEmpty()){
            model.addAttribute("list",new com.furkan.todo_app.model.List());
            model.addAttribute("pageTitle","There is no List so :You have to Add New List");
            return "list_form";
        }
        model.addAttribute("pageTitle","Create Item");

        model.addAttribute("listLists",listLists);
        model.addAttribute("item",new Item());
        return "item_form";
    }

    // Post metodu ile Itemı kayıt ediyorum. POST kullanma sebebim url de verilerin görünmemesi için
    @PostMapping("/items/save")
    public String saveItem(Item item, RedirectAttributes ra){
        itemService.save(item);
//        ra.addFlashAttribute("message","The Item has been saved succesfuly");
        return "redirect:/";
    }

    // Item Id si ile forma kayıtlı bilgileri gösteriyorum .
    @GetMapping("/items/edit/{id}")
    public String showEditFormItem(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Item item = itemService.get(id);
            model.addAttribute("item",item);
            model.addAttribute("pageTitle","Edit Item");
            List<com.furkan.todo_app.model.List> listLists = listService.listAll();
            model.addAttribute("listLists",listLists);

            return "item_form";
        } catch (ItemNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/ ";
        }
    }

    //     Item Id si ile silme işlmei yapıyorum
    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable("id") Integer id,RedirectAttributes ra) throws ItemNotFoundException {
        try {
            itemService.delete(id);
            ra.addFlashAttribute("message","The Item ID "+id+" has been deleted.");

        } catch (ItemNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/ ";
    }
}
