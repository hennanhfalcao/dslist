package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.dtos.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(game);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
       List<Game> games = gameRepository.findAll();
       List<GameMinDTO> gamesDto = games.stream().map(GameMinDTO::new).toList();
       return gamesDto;
    }



}
