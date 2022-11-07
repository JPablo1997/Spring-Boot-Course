package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {

	public abstract Optional<Student> findByEmail(String email); 
}
