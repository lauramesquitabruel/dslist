package com.bruel.dslist.services;

import com.bruel.dslist.dto.GameDTO;
import com.bruel.dslist.dto.GameListDTO;
import com.bruel.dslist.dto.GameMinDTO;
import com.bruel.dslist.entities.Game;
import com.bruel.dslist.entities.GameList;
import com.bruel.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository repository;

    /*@Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        GameList result = repository.findById(id).get();
        GameListDTO dto = new GameListDTO(result);
        return dto;
    }*/

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = repository.findAll();
        List<GameListDTO> dto = result.stream().map(gameList -> new GameListDTO(gameList)).toList();
        return dto;
    }
}
