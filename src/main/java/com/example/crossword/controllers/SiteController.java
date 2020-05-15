package com.example.crossword.controllers;

import com.example.crossword.controllers.api.ClueController;
import com.example.crossword.exceptions.crosswordManagerExceptions.InvalidLetterException;
import com.example.crossword.entities.ClueEntity;
import com.example.crossword.models.Grid;
import com.example.crossword.services.crosswordManager.CrosswordInsertManager;
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
        model.addAttribute("clue", new ClueEntity());
        return "redirect:add-clue.html";
    }

    @PostMapping("/clue")
    public String addNewClue (@ModelAttribute ClueEntity clue) {
        clueController.postClue(clue);
        return "redirect:clue-submitted.html";
    }

    @GetMapping("/build-a-crossword")
    public String buildACrossword(Model model) {
        Grid grid = CrosswordInsertManager.NewCrossword(5, 5).getGrid();
        try {
            grid.getLetterSquares()[1][3].setLetter('A');
            grid.getLetterSquares()[2][3].setLetter('B');
            grid.getLetterSquares()[3][4].setLetter('C');
        } catch (InvalidLetterException e) {
            e.printStackTrace();
        }
        model.addAttribute("grid", grid);

        return "build-a-crossword";
    }
}