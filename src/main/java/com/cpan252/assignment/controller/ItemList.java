package com.cpan252.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cpan252.assignment.repository.ItemRepository;
import org.springframework.ui.Model;
import com.cpan252.assignment.model.dto.ItemSearchByDateAndName;
@Controller
@RequestMapping("/ItemListPage")
public class ItemList {
    private ItemRepository itemRepository;
    
    public ItemList(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    @GetMapping
    public String showItem(Model model){
        return "ItemListPage";
    }

    @ModelAttribute
    public void items(Model model){
        model.addAttribute("items", itemRepository.findAll());
    }
    @ModelAttribute
    public void itemSearchByDateAndName(Model model) {
        model.addAttribute("itemSearchByDateAndName", new ItemSearchByDateAndName());
    }
    @PostMapping
    public String searchItemByNameandDate(@ModelAttribute ItemSearchByDateAndName itemSearchByDateAndName,
            Model model) {
        model.addAttribute("items", itemRepository.findByBrandAndPrucdedDate(
            itemSearchByDateAndName.getBrand(), itemSearchByDateAndName.getPrucdedDate()));
        return "ItemList";
    }
}
