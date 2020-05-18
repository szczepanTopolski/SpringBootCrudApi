package com.codecool.SpringRestApi.repository;

import com.codecool.SpringRestApi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findFirstById(Integer id);
    List<Student> getAllByIdIsNotNull();
}
