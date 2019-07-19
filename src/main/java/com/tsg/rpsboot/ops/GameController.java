/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.rpsboot.ops;

import com.tsg.rpsboot.biz.GameServiceImpl;
import com.tsg.rpsboot.biz.exceptions.InvalidChoiceException;
import com.tsg.rpsboot.dto.GameRound;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author austynhill
 */
@RestController
public class GameController {
    @Autowired
    private GameServiceImpl service;
    
    @GetMapping("/rounds")
    public List<GameRound> getDaRounds(){
        return service.getAllRounds();
    }
    
    @PostMapping("/play/{choice}")
    public GameRound playRound(@PathVariable("choice") String playerChoice) throws InvalidChoiceException{
        return this.service.addRound(playerChoice);
    }
    
}
