package com.grumble.mapper;

import com.grumble.entities.Pet;
import com.grumble.dto.PetDto;

public interface PetMapper {
    PetDto mapEntityToPet(Pet petEntity);
    Pet mapPetToEntity(PetDto petDto);
}
