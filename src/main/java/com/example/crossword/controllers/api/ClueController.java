package com.example.crossword.controllers.api;

import com.example.crossword.exceptions.ClueNotFoundException;
import com.example.crossword.entities.ClueEntity;
import com.example.crossword.repositories.ClueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/clue")
public class ClueController {
    @Autowired
    private ClueRepository clueRepository;

    @GetMapping("/{id}")
    ClueEntity getClue(@PathVariable Integer id) throws ClueNotFoundException {
        return clueRepository.findById(id)
                .orElseThrow(() -> new ClueNotFoundException(id));
    }

    @PostMapping
    public void postClue(@RequestBody ClueEntity clue) {
        clueRepository.save(clue);
    }

}
