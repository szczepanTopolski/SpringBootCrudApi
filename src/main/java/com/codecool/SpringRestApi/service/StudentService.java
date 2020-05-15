package com.codecool.SpringRestApi.service;


import com.codecool.SpringRestApi.dao.DAO;
import com.codecool.SpringRestApi.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private DAO studentDao;

    public StudentService(@Qualifier("StudentDao") DAO studentDao){
        this.studentDao = studentDao;
    }


    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }


    public Optional<Student> getStudentById(UUID id) {
        return studentDao.getStudentById(id);
    }


    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }


    public void updateStudent(UUID id, Student newStudent) {
        studentDao.updateStudent(id, newStudent);
    }


    public void deleteStudent(UUID id) {
        studentDao.deleteStudent(id);
    }
}
