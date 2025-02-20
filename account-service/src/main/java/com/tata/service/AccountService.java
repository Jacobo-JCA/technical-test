package com.tata.service;

import com.tata.entity.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account) throws Exception;
    List<Account> readAll() throws Exception;
    Account findById(Integer id) throws Exception;
    Account update(Account account, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
