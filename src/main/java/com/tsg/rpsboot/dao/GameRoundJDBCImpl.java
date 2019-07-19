/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.rpsboot.dao;

import com.tsg.rpsboot.dto.GameRound;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author austynhill
 */
@Repository
public class GameRoundJDBCImpl implements DAO<GameRound> {

    @Autowired
    private JdbcTemplate heySQL;

    @Override
    public GameRound add(GameRound toAdd) {
        String sql = "INSERT INTO GameRounds(`PlayerChoice`, `ComputerChoice`, `TimeStamp`) VALUES(?, ?, ?)";
        heySQL.update(sql, toAdd.getPlayerChoice(), toAdd.getCompChoice(), toAdd.getTimestamp().toString());
        toAdd.setId(heySQL.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
        return toAdd;
    }

    @Override
    public GameRound get(int id) {
        String sql = "SELECT * FROM GameRounds WHERE Id = ?";
        return heySQL.queryForObject(sql, new GameRoundMapper(), id);
    }

    @Override
    public List<GameRound> getAll() {
        String sql = "SELECT * FROM GameRounds";
        return heySQL.query(sql, new GameRoundMapper());
    }

    @Override
    public void edit(GameRound toUpdate) {
        String sql = "UPDATE GameRounds SET PlayerChoice = ?, ComputerChoice = ?, `TimeStamp` = ? WHERE Id = ?";
        heySQL.update(sql, 
                toUpdate.getPlayerChoice(), 
                toUpdate.getCompChoice(), 
                toUpdate.getTimestamp().toString(), 
                toUpdate.getId()
        );
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM GameRounds WHERE Id = 1";
        heySQL.update(sql, id   );
    }

}
