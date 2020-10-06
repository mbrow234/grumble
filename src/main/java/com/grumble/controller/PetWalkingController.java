package com.grumble.controller;

import com.grumble.service.PetWalkingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PetWalkingController {

    private PetWalkingService petWalkingService;

    @Autowired
    public PetWalkingController(PetWalkingService petWalkingService) {
        this.petWalkingService = petWalkingService;
    }

    //TODO: implement
}
