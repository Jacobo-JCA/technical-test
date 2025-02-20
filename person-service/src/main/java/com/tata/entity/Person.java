package com.tata.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person {
    @Transient
    private Integer idPerson;
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
    protected String genre;
    @Column(nullable = false)
    protected int age;
    @Column(nullable = false)
    protected String ci;
    @Column(nullable = false, length = 150)
    protected String address;
    @Column(nullable = false, length = 10)
    protected String telephone;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(idPerson, person.idPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPerson);
    }
}
