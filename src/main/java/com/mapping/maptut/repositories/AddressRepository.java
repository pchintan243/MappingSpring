package com.mapping.maptut.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.mapping.maptut.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
    public Optional<Integer> findById(int id);
}
