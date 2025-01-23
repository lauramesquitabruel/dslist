package com.bruel.dslist.controllers;

import com.bruel.dslist.dto.GameDTO;
import com.bruel.dslist.dto.GameListDTO;
import com.bruel.dslist.dto.GameMinDTO;
import com.bruel.dslist.entities.GameList;
import com.bruel.dslist.services.GameListService;
import com.bruel.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService service;

    /*@GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable  Long id){
        GameDTO result = service.findById(id);
        return result;
    }*/

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = service.findAll();
        return result;
    }
}
