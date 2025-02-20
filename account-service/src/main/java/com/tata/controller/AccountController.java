package com.tata.controller;

import com.tata.dto.AccountDTO;
import com.tata.entity.Account;
import com.tata.service.AccountService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class AccountController {
    private final AccountService service;
    private final ModelMapper mapper;

    public AccountController(AccountService service, @Qualifier("accountMapper") ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/public/accounts")
    public ResponseEntity<AccountDTO> create(@Valid @RequestBody AccountDTO dto) throws Exception {
        Account obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @GetMapping("/public/accounts")
    public ResponseEntity<List<AccountDTO>> readAll() throws Exception {
        List<AccountDTO> list = service.readAll().stream()
                .map(this::convertToDto).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/admin/account/{accountId}")
    public ResponseEntity<AccountDTO> update(@Valid @RequestBody AccountDTO accountDTO, @PathVariable Integer accountId)
            throws Exception {
        accountDTO.setIdAccount(accountId);
        Account obj = service.update(this.convertToEntity(accountDTO), accountId);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/admin/account/{accountId}")
    public ResponseEntity<AccountDTO> deleteCategory(@PathVariable Integer accountId) throws Exception {
        service.delete(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private AccountDTO convertToDto(Account obj) {
        return mapper.map(obj, AccountDTO.class);
    }
    private Account convertToEntity(AccountDTO dto) {
        return mapper.map(dto, Account.class);
    }
}
