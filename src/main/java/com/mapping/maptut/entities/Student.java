package com.mapping.maptut.entities;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(exclude = { "laptop", "addressList" })
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;

    private String about;

    @OneToOne
    @JsonManagedReference
    private Laptop laptop;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Address> addressList = new ArrayList<>();
}
