package com.example.crossword.controllers;

import com.example.crossword.controllers.api.ClueController;
import com.example.crossword.exceptions.crosswordManagerExceptions.InvalidLetterException;
import com.example.crossword.models.Clue;
import com.example.crossword.models.Grid;
import com.example.crossword.services.crosswordManager.CrosswordInsertManager;
import com.example.crossword.viewModels.CrosswordViewModel;
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
        CrosswordViewModel crosswordViewModel = new CrosswordViewModel(grid);
        model.addAttribute("crossword", crosswordViewModel);

        return "build-a-crossword";
    }

//    @GetMapping("/crossword/{id}")
//    public String editCrossword(Model model, @PathVariable("id") String id) {
//
//        CrosswordViewModel crosswordViewModel = getCrosswordFromDatabaseWithId(id);
//        model.addAttribute("crossword", crosswordViewModel);
//
//        return "build-a-crossword";
//    }
}