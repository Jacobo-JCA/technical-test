package com.tata.repository;

import com.tata.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepo extends JpaRepository<Movement, Integer> {
}
