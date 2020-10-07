package com.grumble.service;

import com.grumble.dto.PetDto;

import java.util.List;

public interface PetService {
    PetDto getPetById(Long id);
    List<PetDto> getAllPets();
    List<PetDto> getPetsByUserId(Long id);
    Long deletePetById(Long id);
    PetDto createPet(PetDto petDto);
    PetDto updatePet(PetDto petDto);
}
