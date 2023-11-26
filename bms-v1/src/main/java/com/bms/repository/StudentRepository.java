package com.bms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Optional<Student> findByNameAndPassword(String name, String password);

}
