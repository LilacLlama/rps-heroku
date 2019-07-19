/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.rpsboot.dao;

import com.tsg.rpsboot.dto.GameRound;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author austynhill
 */
public class GameRoundMapper implements RowMapper<GameRound>{

    @Override
    public GameRound mapRow(ResultSet rs, int i) throws SQLException {
        GameRound fromDB = new GameRound();
        fromDB.setId(rs.getInt("Id"));
        fromDB.setPlayerChoice(rs.getString("PlayerChoice"));
        fromDB.setCompChoice(rs.getString("ComputerChoice"));
        fromDB.setTimestamp(rs.getTimestamp("TimeStamp").toLocalDateTime());
        return fromDB;
    }
    
}
