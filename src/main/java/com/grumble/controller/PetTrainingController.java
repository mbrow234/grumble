package com.grumble.controller;

import com.grumble.service.PetTrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PetTrainingController {

    private PetTrainingService petTrainingService;

    @Autowired
    public PetTrainingController(PetTrainingService petTrainingService) {
        this.petTrainingService = petTrainingService;
    }

    //TODO: implement
}
