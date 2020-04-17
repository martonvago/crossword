package com.example.crossword.controllers;

import com.example.crossword.models.Clue;
import com.example.crossword.repositories.ClueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private ClueRepository clueRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewClue (
        @RequestParam String clue, @RequestParam String answer
    ) {

        return "hello";
    }
}