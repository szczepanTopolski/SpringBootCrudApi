package com.codecool.SpringRestApi.controller;

import com.codecool.SpringRestApi.model.Student;
import com.codecool.SpringRestApi.service.StudentNotFoundException;
import com.codecool.SpringRestApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/student")
class StudentController {

    private StudentService studentService;

    @Autowired
    StudentController(StudentService studentService){
        this.studentService = studentService;

    }

    @PostMapping
    public void insertStudent(@RequestBody  Student student){
        studentService.insertStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable("id") UUID id) throws StudentNotFoundException {
        final Optional<Student> studentById = studentService.getStudentById(id);
        if(studentById.isPresent()) return studentById.get();
        else throw new StudentNotFoundException();
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "No user of such id found.")
    void handleStudentNotFoundException(){}


    @PutMapping("{id}")
    public void updateStudent(@PathVariable("id") UUID id, @RequestBody Student student){
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") UUID id){
        studentService.deleteStudent(id);
    }

}
