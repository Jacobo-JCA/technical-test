package com.tata.controller;

import com.tata.dto.MovementDTO;
import com.tata.entity.Movement;
import com.tata.service.MovementService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class MovementController {
    private final MovementService service;
    private final ModelMapper mapper;

    public MovementController(MovementService service, @Qualifier("movementMapper") ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/public/movements/{accountId}")
    public ResponseEntity<MovementDTO> create(@PathVariable Integer accountId, @Valid @RequestBody MovementDTO dto)
            throws Exception {
        Movement obj = service.save(accountId, this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @GetMapping("/public/movements")
    public ResponseEntity<List<MovementDTO>> readAll() throws Exception {
        List<MovementDTO> list = service.readAll().stream()
                .map(this::convertToDto).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/admin/movement/{movementId}")
    public ResponseEntity<MovementDTO> update(@Valid @RequestBody MovementDTO movementDTO, @PathVariable Integer movementId)
            throws Exception {
        movementDTO.setIdMovement(movementId);
        Movement obj = service.update(this.convertToEntity(movementDTO), movementId);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/admin/movement/{movementId}")
    public ResponseEntity<MovementDTO> deleteCategory(@PathVariable Integer movementId) throws Exception {
        service.delete(movementId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private MovementDTO convertToDto(Movement obj) {
        return mapper.map(obj, MovementDTO.class);
    }
    private Movement convertToEntity(MovementDTO dto) {
        return mapper.map(dto, Movement.class);
    }
}
