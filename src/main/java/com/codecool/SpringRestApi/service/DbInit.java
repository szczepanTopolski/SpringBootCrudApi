package com.codecool.SpringRestApi.service;

import com.codecool.SpringRestApi.model.Student;
import com.codecool.SpringRestApi.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    private StudentRepository studentRepository;

    public DbInit(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {

        Student janek = new Student("Janek");
        Student basia = new Student("basia");
        Student kasia = new Student("kasia");
        Student adam = new Student("adam");
        Student kamil = new Student("kamil");

        List<Student> students = Arrays.asList(janek, basia, kasia, adam, kamil);

        this.studentRepository.saveAll(students);
    }
}