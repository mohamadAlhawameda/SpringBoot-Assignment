package com.cpan252.assignment.controller;
import java.util.EnumSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import com.cpan252.assignment.model.item;
import com.cpan252.assignment.model.item.Anime;
import com.cpan252.assignment.repository.ItemRepository;
@Controller
@Slf4j

@RequestMapping("/additems")

public class ItemAdd {
    @Autowired
    private ItemRepository itemRepository;
    @GetMapping
    public String additems(){
        return "additems";
    }
    @ModelAttribute
    public void animes(Model model) {
        var animes = EnumSet.allOf(Anime.class);
        model.addAttribute("animes", animes);
        log.info("animes converted to string:  {}", animes);
    }
  
    @ModelAttribute
    // This model attribute has a lifetime of a request
    public item item() {
        return item
                .builder()
                .build();
    }
    @PostMapping
    public String processFighterAddition(@Valid item item, BindingResult result) {
        if (result.hasErrors()) {
            return "design";
        }
        log.info("Processing item: {}", item);
        itemRepository.save(item);
        return "redirect:/ItemListPage";
    }

}