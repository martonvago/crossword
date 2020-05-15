package com.example.crossword.repositories;

import com.example.crossword.entities.CrosswordEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrosswordRepository extends CrudRepository<CrosswordEntity, Integer> {
}
