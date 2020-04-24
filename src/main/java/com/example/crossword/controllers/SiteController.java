package com.example.crossword.controllers;

import com.example.crossword.controllers.api.ClueController;
import com.example.crossword.models.Clue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SiteController {
    @Autowired
    private ClueController clueController;

    @GetMapping("/clue")
    public String addClueForm(Model model) {
        model.addAttribute("clue", new Clue());
        return "redirect:add-clue.html";
    }

    @PostMapping("/clue")
    public String addNewClue (@ModelAttribute Clue clue) {
        clueController.postClue(clue);
        return "redirect:clue-submitted.html";
    }
}