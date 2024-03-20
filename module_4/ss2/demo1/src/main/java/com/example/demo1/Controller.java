package com.example.demo1;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/")

public class Controller {
    @GetMapping("/")
    public String showList() {
        return "Home";
    }

    @PostMapping
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("list", String.join(", ", condiment));
        return "Home";
    }
}
