package com.tata.service.impl;

import com.tata.entity.Movement;
import com.tata.exception.ModelNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MovementTransactionService {
    public double processMovement(Movement movement, double currentBalance) {
        double newBalance = currentBalance;

        switch (movement.getMovementType()) {
            case DEPOSIT -> {
                newBalance += movement.getValue();
            }
            case WITHDRAWAL, TRANSFER -> {
                if (newBalance >= movement.getValue()) {
                    newBalance -= movement.getValue();
                } else {
                    throw new ModelNotFoundException("Insufficient balance for withdrawal or transfer");
                }
            }
            default -> throw new ModelNotFoundException("Invalid movement type");
        }
        return newBalance;
    }
}
