package com.bruel.dslist.servicies;

import com.bruel.dslist.dto.GameMinDTO;
import com.bruel.dslist.entities.Game;
import com.bruel.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public List<GameMinDTO> findAll(){
        List<Game> result = repository.findAll();
        List<GameMinDTO> dto = result.stream().map(game -> new GameMinDTO(game)).toList();
        return dto;
    }
}
