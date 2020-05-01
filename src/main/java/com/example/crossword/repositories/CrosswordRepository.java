package com.example.crossword.repositories;

import com.example.crossword.models.Crossword;
import org.springframework.data.repository.CrudRepository;

public interface CrosswordRepository extends CrudRepository<Crossword, Integer> {
}
