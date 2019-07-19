/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.rpsboot.dto;

import java.time.LocalDateTime;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author austynhill
 */
@Getter @Setter
@ToString @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class GameRound {
    private int id;
    private String playerChoice;
    private String compChoice;
    private LocalDateTime timestamp;
    
    private static Random r = new Random();
    public static String[] choices = {"ROCK", "PAPER", "SCISSORS"};
    
    
    public GameRound(String playerChoice){
        this.playerChoice = playerChoice.toUpperCase();
        this.compChoice = choices[r.nextInt(choices.length)];
        this.timestamp = LocalDateTime.now();
    }
        
    public String getResult(){
        switch(playerChoice.toUpperCase()+"."+compChoice.toUpperCase()){
            case "ROCK.ROCK":
            case "PAPER.PAPER":
            case "SCISSORS.SCISSORS":
                return "BOTH TIE";
            
            case "ROCK.PAPER":
            case "PAPER.SCISSORS":
            case "SCISSORS.ROCK":
                return "COMPUTER WIN";

            case "PAPER.ROCK":
            case "SCISSORS.PAPER":
            case "ROCK.SCISSORS":
                return "PLAYER WIN";
            
            default:
                return "ERROR";
                
        }
    }
}
