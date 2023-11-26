package com.bms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

	Optional<Faculty> findByNameAndPassword(String userName, String password);

}
