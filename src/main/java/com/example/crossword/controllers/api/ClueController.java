package com.example.crossword.controllers.api;

import com.example.crossword.exceptions.ClueNotFoundException;
import com.example.crossword.models.Clue;
import com.example.crossword.repositories.ClueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/clue")
class ClueController {
    @Autowired
    private ClueRepository clueRepository;

    @GetMapping("/{id}")
    Clue getClue(@PathVariable Integer id) throws ClueNotFoundException {
        return clueRepository.findById(id)
                .orElseThrow(() -> new ClueNotFoundException(id));
    }
}
