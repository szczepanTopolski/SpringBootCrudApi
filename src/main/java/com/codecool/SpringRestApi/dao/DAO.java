package com.codecool.SpringRestApi.dao;

import com.codecool.SpringRestApi.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DAO {
    default void insertStudent(Student student){
        UUID id = UUID.randomUUID();
        insertStudent(id, student);
    }
    void insertStudent(UUID id, Student student);
    Optional<Student> getStudentById(UUID id);
    List<Student> getAllStudents();
    void updateStudent(UUID id, Student newStudent);
    void deleteStudent(UUID id);

}
