package com.grumble.mapper.impl;

import com.grumble.entities.Pet;
import com.grumble.mapper.PetMapper;
import com.grumble.dto.PetDto;
import org.springframework.stereotype.Service;

@Service
public class PetMapperImpl implements PetMapper {

    public PetMapperImpl() {

    }

    public PetDto mapEntityToPet(Pet petEntity) {
        PetDto petDto = new PetDto();

        petDto.setId(petEntity.getId());
        petDto.setAnimalType(petEntity.getAnimalType());
        petDto.setPetName(petEntity.getPetName());
        petDto.setBirthDay(petEntity.getBirthDay());
        petDto.setDescription(petEntity.getDescription());
        petDto.setUserId(petEntity.getUserId());

        return petDto;
    }

    public Pet mapPetToEntity(PetDto petDto) {
        Pet petEntity = new Pet();

        petEntity.setId(petDto.getId());
        petEntity.setAnimalType(petDto.getAnimalType());
        petEntity.setBirthDay(petDto.getBirthDay());
        petEntity.setPetName(petDto.getPetName());
        petEntity.setDescription(petDto.getDescription());
        petEntity.setUserId(petDto.getUserId());

        return petEntity;
    }
}
