/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.rpsboot.biz;

import com.tsg.rpsboot.biz.exceptions.InvalidChoiceException;
import com.tsg.rpsboot.dao.DAO;
import com.tsg.rpsboot.dto.GameRound;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author austynhill
 */
@Component
public class GameServiceImpl {

    @Autowired
    private DAO<GameRound> roundsRepo;

    public GameRound addRound(String playerChoice) throws InvalidChoiceException {
        playerChoice = playerChoice.toUpperCase();
        this.validatePlayersChoice(playerChoice);
        return roundsRepo.add(new GameRound(playerChoice));
    }

    private void validatePlayersChoice(String playerChoice) throws InvalidChoiceException {
        if (playerChoice == null || playerChoice.isEmpty()) {
            throw new InvalidChoiceException("You must make a choice to play.");
        } else if (!Arrays.asList(GameRound.choices).contains(playerChoice)) {
            throw new InvalidChoiceException("You chose incorrectly. Please try again.");
        }
    }
    
    public List<GameRound> getAllRounds(){
        return roundsRepo.getAll();
    }

}
