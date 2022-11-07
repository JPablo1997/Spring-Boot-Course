package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
    public List<Student> getStudents() {
		return this.studentRepository.findAll();
	}
    
    public void addNewStudent(Student student) {
    	Optional<Student> studentOpt = this.studentRepository.findByEmail(student.getEmail());
    	
    	if(studentOpt.isPresent()) {
    		throw new IllegalStateException("Email already taken.");
    	}
    	
    	//System.out.println(student);
    	this.studentRepository.save(student);
    }
    
    public void deleteStudent(Long id) {
    	if(! this.studentRepository.existsById(id)) {
    		throw new IllegalStateException("Student with id: " + id + " doesn't exists.");
    	}
    	
    	this.studentRepository.deleteById(id);
    }

}