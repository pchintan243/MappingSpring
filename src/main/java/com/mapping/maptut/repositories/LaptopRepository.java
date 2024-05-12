package com.mapping.maptut.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mapping.maptut.entities.Laptop;


public interface LaptopRepository extends CrudRepository<Laptop, Integer> {
    public Laptop findById(int id);
}
