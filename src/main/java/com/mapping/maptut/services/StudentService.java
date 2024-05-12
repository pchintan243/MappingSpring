package com.mapping.maptut.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.maptut.entities.Address;
import com.mapping.maptut.entities.CreateStudent;
import com.mapping.maptut.entities.Laptop;
import com.mapping.maptut.entities.Student;
import com.mapping.maptut.repositories.AddressRepository;
import com.mapping.maptut.repositories.LaptopRepository;
import com.mapping.maptut.repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    public Student createStudent(CreateStudent student) {

        int laptopId = student.getLaptopId();
        Laptop laptop = laptopRepository.findById(laptopId);

        List<Integer> addressIds = student.getAddressList();
        List<Address> addresses = new ArrayList<>();

        for (Integer addressId : addressIds) {
            Optional<Address> add = addressRepository.findById(addressId);
            if (add.isPresent()) {
                addresses.add(add.get());
            }
        }

        if (laptop == null || addresses.isEmpty()) {
            return null;
        }

        Student studentData = new Student();
        studentData.setAbout(student.getAbout());
        studentData.setStudentName(student.getStudentName());
        studentData.setLaptop(laptop);
        studentData.setAddressList(addresses);

        laptop.setStudent(studentData);

        Student newStudent = studentRepository.save(studentData);
        laptopRepository.save(laptop);

        for (Address address : addresses) {
            if (address.getStudent() == null) {
                address.setStudent(newStudent);
            } else {
                // Create a new instance of Address with the same details
                Address newAddress = new Address();
                newAddress.setStreet(address.getStreet());
                newAddress.setCity(address.getCity());
                newAddress.setCountry(address.getCountry());
                newAddress.setStudent(newStudent);
                addressRepository.save(newAddress);
            }
        }
        addressRepository.saveAll(addresses);
        return newStudent;
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }
}
