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
        @RequestBody Clue clue
    ) {
        String hello = "we don't know";
        if (clue.getAnswer() == null) {
            hello = "it was null";
        } else {
            hello = clue.getAnswer();
        }
        return hello;
    }
}