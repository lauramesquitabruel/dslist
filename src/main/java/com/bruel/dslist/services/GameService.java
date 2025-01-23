package com.bruel.dslist.services;

import com.bruel.dslist.dto.GameDTO;
import com.bruel.dslist.dto.GameMinDTO;
import com.bruel.dslist.entities.Game;
import com.bruel.dslist.projections.GameMinProjection;
import com.bruel.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = repository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = repository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = repository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }
}
