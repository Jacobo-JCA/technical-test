package com.tata.config;

import com.tata.dto.AccountDTO;
import com.tata.dto.MovementDTO;
import com.tata.entity.Account;
import com.tata.entity.Movement;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Objects;

@Configuration
public class MapperConfig {
    @Bean("movementMapper")
    public ModelMapper mapperMovement() {
        ModelMapper mapperMovement = new ModelMapper();
        TypeMap<MovementDTO, Movement> typeMapMovement = mapperMovement.createTypeMap(MovementDTO.class, Movement.class);
        typeMapMovement.addMappings(mapper -> {
            mapper.map(MovementDTO::getIdMovement, Movement::setIdMovement);
            mapper.map(MovementDTO::getMovementType, Movement::setMovementType);
            mapper.map(MovementDTO::getValue, Movement::setValue);
            mapper.map(MovementDTO::getBalance, Movement::setBalance);
            mapper.when(Objects::isNull).map(src -> LocalDateTime.now(), Movement::setDate);
        });

        TypeMap<Movement, MovementDTO> typeMapMovementDTO = mapperMovement.createTypeMap(Movement.class, MovementDTO.class);
        typeMapMovementDTO.addMappings(mapper -> {
            mapper.map(Movement::getIdMovement, MovementDTO::setIdMovement);
            mapper.map(Movement::getDate, MovementDTO::setDate);
            mapper.map(Movement::getMovementType, MovementDTO::setMovementType);
            mapper.map(Movement::getValue, MovementDTO::setValue);
            mapper.map(Movement::getBalance, MovementDTO::setBalance);
        });

        return mapperMovement;
    }

    @Bean("accountMapper")
    public ModelMapper mapperAccount() {
        ModelMapper mapperAccount = new ModelMapper();
        TypeMap<AccountDTO, Account> typeMapAccount = mapperAccount.createTypeMap(AccountDTO.class, Account.class);
        typeMapAccount.addMappings(mapper -> {
            mapper.map(AccountDTO::getIdAccount, Account::setIdAccount);
            mapper.map(AccountDTO::getAccountNumber, Account::setAccountNumber);
            mapper.map(AccountDTO::getInitialBalance, Account::setInitialBalance);
            // Si en el futuro agregas más atributos (como state) en AccountDTO, se pueden mapear aquí.
        });

        TypeMap<Account, AccountDTO> typeMapAccountDTO = mapperAccount.createTypeMap(Account.class, AccountDTO.class);
        typeMapAccountDTO.addMappings(mapper -> {
            mapper.map(Account::getIdAccount, AccountDTO::setIdAccount);
            mapper.map(Account::getAccountNumber, AccountDTO::setAccountNumber);
            mapper.map(Account::getInitialBalance, AccountDTO::setInitialBalance);
        });

        return mapperAccount;
    }
}

