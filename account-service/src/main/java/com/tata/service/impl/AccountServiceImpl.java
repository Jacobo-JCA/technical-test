package com.tata.service.impl;

import com.tata.entity.Account;
import com.tata.exception.ModelNotFoundException;
import com.tata.repository.AccountRepo;
import com.tata.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepo repo;

    @Override
    public Account save(Account account) throws Exception {
        return repo.save(account);
    }

    @Override
    public List<Account> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Account findById(Integer id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXIST" + id));
    }

    @Override
    public Account update(Account account, Integer id) throws Exception {
        repo.findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXIST" + id));
        return repo.save(account);
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXIST" + id));
        repo.deleteById(id);
    }
}
