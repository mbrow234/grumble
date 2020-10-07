package com.grumble.service.impl;

import com.grumble.dto.PetDto;
import com.grumble.entities.Pet;
import com.grumble.mapper.PetMapper;
import com.grumble.repository.PetRepository;
import com.grumble.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;
    private PetMapper petMapper;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    @Override
    public PetDto getPetById(Long id) {
        Optional<Pet> petOptional = petRepository.findById(id);

        if (petOptional.isPresent()) {
            return petMapper.mapEntityToPet(petOptional.get());
        } else {
            return null;
        }
    }

    @Override
    public List<PetDto> getAllPets() {
        List<PetDto> petDtos = new ArrayList<>();

        petRepository.findAll().forEach(pet -> petDtos.add(petMapper.mapEntityToPet(pet)));

        return petDtos;
    }

    @Override
    public Long deletePetById(Long id) {

        try {
            petRepository.deleteById(id);
        } catch (Exception e) {
            log.warn("Failed to delete pet by id: {}", id);
            return null;
        }


        return id;
    }

    @Override
    public PetDto createPet(PetDto petDto) {
        Pet createdPet;
        try {
            createdPet = petRepository.save(petMapper.mapPetToEntity(petDto));
        } catch (Exception e) {
            return null;
        }

        return petMapper.mapEntityToPet(createdPet);
    }

    @Override
    public PetDto updatePet(PetDto petDto) {
        PetDto updatedPetDto;

        try {
            Pet updatedPet = petRepository.save(petMapper.mapPetToEntity(petDto));
            updatedPetDto = petMapper.mapEntityToPet(updatedPet);
        } catch (Exception e) {
            return null;
        }

        return updatedPetDto;
    }
}
