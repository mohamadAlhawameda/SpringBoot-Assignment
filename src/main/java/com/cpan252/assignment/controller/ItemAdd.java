package com.cpan252.assignment.controller;
import java.util.EnumSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.extern.slf4j.Slf4j;
import com.cpan252.assignment.model.item;
import com.cpan252.assignment.model.item.Anime;

import org.springframework.ui.Model;
@Controller
@Slf4j

@RequestMapping("/additems")

public class ItemAdd {
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
    public item Item() {
        return item
                .builder()
                .build();
    }
    @PostMapping
    public String processFighterAddition(@Valid item Item, BindingResult result) {
        if (result.hasErrors()) {
            return "additems";
        }
        return "redirect:/additems";

    }

}


