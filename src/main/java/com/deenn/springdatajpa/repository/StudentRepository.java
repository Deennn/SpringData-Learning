package com.deenn.springdatajpa.repository;

import com.deenn.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student > findByFirstName(String firstName);
    List<Student > findByFirstNameContaining(String firstName);

}
