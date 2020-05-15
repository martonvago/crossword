package com.example.crossword.controllers.api;

import com.example.crossword.exceptions.ClueNotFoundException;
import com.example.crossword.models.Clue;
import com.example.crossword.repositories.ClueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/clue")
public class ClueController {
    @Autowired
    private ClueRepository clueRepository;

    @GetMapping("/{id}")
    Clue getClue(@PathVariable Integer id) throws ClueNotFoundException {
        return clueRepository.findById(id)
                .orElseThrow(() -> new ClueNotFoundException(id));
    }

    @PostMapping
    public void postClue(@RequestBody Clue clue) {
        clueRepository.save(clue);
    }

}
