package com.grumble.mapper;

import com.grumble.model.Pet;
import org.springframework.stereotype.Service;

@Service
public class PetMapper {

    public PetMapper() {

    }

    public Pet mapEntityToPet(com.grumble.entities.Pet petEntity) {
        Pet pet = new Pet();

        pet.setId(petEntity.getId());
        pet.setAnimalType(petEntity.getAnimalType());
        pet.setPetName(petEntity.getPetName());
        pet.setBirthDay(petEntity.getBirthDay());

        return pet;
    }

    public com.grumble.entities.Pet mapPetToEntity(Pet pet) {
        com.grumble.entities.Pet petEntity = new com.grumble.entities.Pet();

        petEntity.setId(pet.getId());
        petEntity.setAnimalType(pet.getAnimalType());
        petEntity.setBirthDay(pet.getBirthDay());
        petEntity.setPetName(pet.getPetName());

        return petEntity;
    }
}
