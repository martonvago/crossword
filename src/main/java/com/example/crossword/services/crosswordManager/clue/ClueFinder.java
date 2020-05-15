package com.example.crossword.services.crosswordManager.clue;

import com.example.crossword.entities.ClueEntity;
import com.example.crossword.models.ClueDirection;
import com.example.crossword.models.GridCoordinates;
import com.example.crossword.repositories.ClueRepository;
import com.example.crossword.services.crosswordManager.grid.GridManager;
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

    public ClueFinder(ClueRepository clueRepository, GridManager gridManager) {
        this.clueRepository = clueRepository;
        this.gridManager = gridManager;
    }

    public List<ClueEntity> findCluesThatCanBeInserted(GridCoordinates startCoords, ClueDirection dir) {
        List<ClueEntity> clues = new ArrayList<ClueEntity>();

        for (ClueEntity clue : clueRepository.findAll()) {
            if (gridManager.canInsertWord(clue.getAnswer(), startCoords, dir)) {
                clues.add(clue);
            }
        }

        return clues;
    }
}
