package com.tata.service.impl;

import com.tata.entity.Account;
import com.tata.entity.Movement;
import com.tata.repository.MovementRepo;
import com.tata.service.AccountService;
import com.tata.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovementServiceImpl implements MovementService {
    private final MovementRepo repo;
    private final AccountService accountService;
    private final MovementTransactionService movementTransactionService;

    @Override
    public Movement save(Integer id, Movement movement) throws Exception {
        Account account = accountService.findById(id);
        movement.setAccount(account);
        double newBalance = movement.getBalance();
        double currentBalance = movementTransactionService.processMovement(movement, newBalance);
        movement.setBalance(currentBalance);
        return repo.save(movement);
    }

    @Override
    public List<Movement> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Movement update(Movement movement, Integer id) throws Exception {
        repo.findById(id).orElseThrow(() -> new RuntimeException("ID NOT EXIST" + id));
        return repo.save(movement);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.findById(id).orElseThrow(() -> new RuntimeException("ID NOT EXIST" + id));
        repo.deleteById(id);
    }
}
