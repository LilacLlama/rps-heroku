/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.rpsboot.dao;

import java.util.List;

/**
 *
 * @author austynhill
 */
public interface DAO<T> {
    
    // C
    public T add(T toAdd);
    
    // R
    public T get(int id);
    public List<T> getAll();
    
    // U
    public void edit(T toUpdate);
    
    // D
    public void delete(int id);
    
}
