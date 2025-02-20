package com.tata.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@ToString
@Setter
@Getter
@AllArgsConstructor
@Entity
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private State state;

    public Customer() {
        this.state = State.ACTIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(idCustomer, customer.idCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idCustomer);
    }
}
