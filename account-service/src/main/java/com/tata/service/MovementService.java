package com.tata.service;

import com.tata.entity.Movement;

import java.util.List;

public interface MovementService {
    Movement save(Integer id, Movement movement) throws Exception;
    List<Movement> readAll() throws Exception;
    Movement update(Movement movement, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
