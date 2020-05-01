package com.example.crossword.services.clue;

import com.example.crossword.models.Clue;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.GridCoordinates;
import com.example.crossword.repositories.ClueRepository;
import com.example.crossword.services.grid.GridManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClueFinder {
    @Autowired
    private ClueRepository clueRepository;

    private GridManager gridManager;

    public ClueFinder(GridManager gridManager) {
        this.gridManager = gridManager;
    }

    public List<Clue> findCluesThatCanBeInserted(GridCoordinates startCoords, ClueDirection dir) {
        List<Clue> clues = new ArrayList<Clue>();

        for (Clue clue : clueRepository.findAll()) {
            if (gridManager.canInsertWord(clue.getAnswer(), startCoords, dir)) {
                clues.add(clue);
            }
        }

        return clues;
    }
}
