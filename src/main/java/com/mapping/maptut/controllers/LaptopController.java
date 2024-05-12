package com.mapping.maptut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.maptut.entities.Laptop;
import com.mapping.maptut.services.LaptopService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @PostMapping("/create-laptop")
    public Laptop createLaptop(@RequestBody Laptop laptop) {
        return laptopService.createLaptop(laptop);
    }

}
