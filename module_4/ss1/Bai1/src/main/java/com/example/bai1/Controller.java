package com.example.bai1;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@org.springframework.stereotype.Controller


@RequestMapping("/")
public class Controller {
    @GetMapping
    public String showList() {
        return "Home";
    }
    @PostMapping("/convertVND")
    public String calculatorVND(@RequestParam float vnd,
                                Model model) {
        float usd = vnd * 24.675f;
        model.addAttribute("usdAmount",usd);
        return "Home";
    }

    @PostMapping("/convertUSD")
    public String calculatorUSD(@RequestParam float usd,
                                Model model) {
        float vnd = usd / 24.675f;
        model.addAttribute("vndAmount",vnd);
        return "Home";
    }
}
