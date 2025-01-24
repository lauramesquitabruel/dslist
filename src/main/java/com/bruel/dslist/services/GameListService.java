package com.bruel.dslist.services;

import com.bruel.dslist.dto.GameDTO;
import com.bruel.dslist.dto.GameListDTO;
import com.bruel.dslist.dto.GameMinDTO;
import com.bruel.dslist.entities.Game;
import com.bruel.dslist.entities.GameList;
import com.bruel.dslist.projections.GameMinProjection;
import com.bruel.dslist.repositories.GameListRepository;
import com.bruel.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository repository;
    @Autowired
    private GameRepository gameRepository;

    /*@Transactional(readOnly = true)
    public GameListDTO findById(Long id){
        GameList result = repository.findById(id).get();
        GameListDTO dto = new GameListDTO(result);
        return dto;
    }*/

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = repository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex;
        int max = destinationIndex;
        if(sourceIndex > destinationIndex){
            min = destinationIndex;
            max = sourceIndex;
        }

        for(int i = min; i <= max; i++){
            repository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
