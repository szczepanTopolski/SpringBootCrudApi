package com.codecool.SpringRestApi.dao;

import com.codecool.SpringRestApi.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class StudentDao implements DAO {
    private static List<Student> students = new ArrayList<>();

    @Bean("StudentDao")
    public StudentDao getStudentDao(){
        return new StudentDao();
    }

    @Override
    public void insertStudent(UUID id, Student student) {
        students.add(new Student(id,student.getName()));
    }

    @Override
    public Optional<Student> getStudentById(UUID id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public void updateStudent(UUID id, Student newStudent) {
        Optional<Student> student = getStudentById(id);
        if (student.isPresent()){
            students.add(new Student(id, newStudent.getName()));
            students.remove(student.get());
        }else{
            throw new IllegalArgumentException();
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void handleIllegalArgumentException(){}


    @Override
    public void deleteStudent(UUID id) {
        Optional<Student> student = getStudentById(id);
        if (student.isPresent()){
            students.remove(student.get());
        }else{
            throw new IllegalArgumentException();
        }
    }
}
