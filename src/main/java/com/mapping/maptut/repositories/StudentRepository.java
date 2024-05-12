package com.mapping.maptut.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mapping.maptut.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
