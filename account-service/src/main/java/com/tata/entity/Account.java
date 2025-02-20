package com.tata.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@ToString
@Setter
@Getter
@AllArgsConstructor
@Table(name = "account_table")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Integer idAccount;
    @Column(nullable = false, name = "account_number", unique = true)
    private String accountNumber;
    @Column(nullable = false, name = "initial_balance")
    private double initialBalance;
    @Enumerated(EnumType.STRING)
    private State state;

    public Account() {
        this.state = State.ACTIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(idAccount, account.idAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idAccount);
    }
}
