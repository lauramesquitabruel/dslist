package com.bruel.dslist.controllers;

import com.bruel.dslist.dto.GameDTO;
import com.bruel.dslist.dto.GameListDTO;
import com.bruel.dslist.dto.GameMinDTO;
import com.bruel.dslist.dto.ReplacementDTO;
import com.bruel.dslist.entities.GameList;
import com.bruel.dslist.services.GameListService;
import com.bruel.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService service;
    @Autowired
    private GameService gameService;

    /*@GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable  Long id){
        GameDTO result = service.findById(id);
        return result;
    }*/

    @GetMapping
    public List<GameListDTO> findAll(){
        return service.findAll();
    }

    @GetMapping(value= "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value= "/{listId}/replacement")
    public void move(@PathVariable long listId, @RequestBody ReplacementDTO body){
        service.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }


}
