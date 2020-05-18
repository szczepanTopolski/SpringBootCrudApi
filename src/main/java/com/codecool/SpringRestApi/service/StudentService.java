package com.codecool.SpringRestApi.service;


import com.codecool.SpringRestApi.model.Student;
import com.codecool.SpringRestApi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService{

    private StudentRepository studentDao;

    public StudentService(StudentRepository studentDao){
        this.studentDao = studentDao;
    }

    public Optional<Student> getStudentById(Integer  id) {
        return studentDao.findFirstById(id);
    }

    public void insertStudent(Student student) {
        studentDao.save(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllByIdIsNotNull();
    }


    public void updateStudent(Integer id, Student newStudent) {
        Optional<Student> student = getStudentById(id);
        if (student.isPresent()){
            student.get().setName(newStudent.getName());
            studentDao.saveAndFlush(student.get());
        }
    }

    public void deleteStudent(Integer id) throws StudentNotFoundException {
        if (studentDao.existsById(id))
            studentDao.deleteById(id);
        else
            throw new StudentNotFoundException();
    }
}
