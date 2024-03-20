package com.example.calculator;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    @GetMapping("/")
    public String showCalculator() {
        return "calculator";
    }
    @PostMapping("{operator}")
    public String calculator(@PathVariable String operator, @RequestParam("number1") float number1, @RequestParam("number2") float number2, Model model) {
        String result = "";
        switch (operator){
            case "add":
                result = String.valueOf(number1+number2);
                break;
            case "sub":
                result = String.valueOf(number1-number2);

                break;
            case "multi":
                result = String.valueOf(number1*number2);
                break;
            case "div":
                if(number2 == 0) {
                    result = "infinity";
                } else
                result = String.valueOf(number1/number2);

                break;
            default:
                result = "Không hợp lệ";
        }
        model.addAttribute("result",result);

        return "calculator";
    }
}
