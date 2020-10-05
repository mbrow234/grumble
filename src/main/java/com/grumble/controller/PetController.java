package com.grumble.controller;

import com.grumble.service.PetService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    //TODO: implement

}
