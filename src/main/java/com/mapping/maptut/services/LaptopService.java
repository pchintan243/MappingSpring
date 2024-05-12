package com.mapping.maptut.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.maptut.entities.Laptop;
import com.mapping.maptut.repositories.LaptopRepository;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }
}
