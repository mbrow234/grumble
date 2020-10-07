package com.grumble.controller;

import com.grumble.dto.PetDto;
import com.grumble.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("pet/{id}")
    public ResponseEntity<PetDto> getPetById(@PathVariable Long id) {
        log.info("REST Resource called - getPetById: {}", id);

        PetDto petDto = petService.getPetById(id);
        if (null == petDto) {
            log.warn("Failed to find pet by id: {}", id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(petDto, HttpStatus.OK);
    }

    @GetMapping("pet")
    public ResponseEntity<List<PetDto>> getAllPets() {
        log.info("REST Resource called - getAllPets");

        List<PetDto> petDtos = petService.getAllPets();
        if (CollectionUtils.isEmpty(petDtos)) {
            log.warn("Failed to find any pets.");
            return new ResponseEntity<>(petDtos, HttpStatus.GONE);
        }

        return new ResponseEntity<>(petDtos, HttpStatus.OK);
    }

    @DeleteMapping("pet/{id}")
    public ResponseEntity<Long> deletePetById(@PathVariable Long id) {
        log.info("REST Resource called - deletePetById: {}", id);

        Long deletedId = petService.deletePetById(id);
        if (null == deletedId) {
            log.warn("Failed to delete pet by id: {}", id);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deletedId, HttpStatus.OK);
    }

    @PostMapping("pet")
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto petDto) {
        log.info("REST Reource called - createPet");

        PetDto createdPet = petService.createPet(petDto);
        if (null == createdPet) {
            log.error("Unable to create pet.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdPet, HttpStatus.OK);
    }

    @PutMapping("pet")
    public ResponseEntity<PetDto> updatePet(@RequestBody PetDto petDto) {
        log.info("REST Resource called - updatePet");

        PetDto updatedPetDto = petService.updatePet(petDto);
        if (null == updatedPetDto) {
            log.error("Unable to update pet.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(updatedPetDto, HttpStatus.OK);
    }

    //TODO: get pets by user id or email

}
