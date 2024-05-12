package com.mapping.maptut.entities;

import java.util.*;

import lombok.Data;

@Data
public class CreateStudent {

    private String studentName;

    private String about;

    private int laptopId;

    private List<Integer> addressList = new ArrayList<Integer>();
}
