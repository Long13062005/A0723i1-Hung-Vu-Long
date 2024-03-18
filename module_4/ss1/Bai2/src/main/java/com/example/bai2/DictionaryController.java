package com.example.bai2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class DictionaryController {

    private String[][] dictionary = {
            {"hello", "xin chào"},
            {"world", "thế giới"},
            // Add more words and their meanings here
    };

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/lookup")
    public String lookupWord(@RequestParam("word") String word, Model model) {
        String meaning = findMeaning(word.toLowerCase());
        if (meaning != null) {
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("message", "Không tìm thấy từ trong từ điển.");
        }
        return "index";
    }

    private String findMeaning(String word) {
        for (String[] entry : dictionary) {
            if (entry[0].equals(word)) {
                return entry[1];
            }
        }
        return null;
    }
}
