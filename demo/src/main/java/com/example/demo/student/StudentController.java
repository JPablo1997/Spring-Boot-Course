package com.example.demo.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*public StudentController() {
        this.studentService = new StudentService();
    }*/

    @GetMapping
	public ResponseEntity<?> index() {
    	List<Student> students = this.studentService.getStudents();
    	final Map<String, Object> responseBody = new HashMap<>();
    	
    	responseBody.put("status", true);
    	responseBody.put("students", students);
    	
    	return ResponseEntity.ok()
    			.header("Content-Type", "application/json")
    			.body(responseBody);
	}
    
    @PostMapping
    public ResponseEntity<?> store(@RequestBody Student student) {
    	final Map<String, Object> responseBody = new HashMap<>();
    	
    	try {
    		this.studentService.addNewStudent(student);
    		responseBody.put("status", true);
    		responseBody.put("message", "Student was created successfully.");
    		
    		return ResponseEntity.ok()
        			.header("Content-Type", "application/json")
        			.body(responseBody);
    		
    	} catch (IllegalStateException e) {
    		responseBody.put("status", false);
    		responseBody.put("message", "There was a problem inserting the new Student.");
    		
    		return ResponseEntity.badRequest()
        			.header("Content-Type", "application/json")
        			.body(responseBody);
    	}
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student student) {
    	final Map<String, Object> responseBody = new HashMap<>();
    	
    	try {
    		this.studentService.updateStudent(id, student);
    		
    		responseBody.put("status", true);
    		responseBody.put("message", "Student was updated successfully.");
    		
    		return ResponseEntity.ok()
        			.header("Content-Type", "application/json")
        			.body(responseBody);
    		
    	} catch (IllegalStateException e) {
    		responseBody.put("status", false);
    		responseBody.put("message", "There was a problem updating the Student.");
    		
    		return ResponseEntity.badRequest()
        			.header("Content-Type", "application/json")
        			.body(responseBody);
    	}
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
    	final Map<String, Object> responseBody = new HashMap<>();
    	
    	try {
    		this.studentService.deleteStudent(id);
    		
    		responseBody.put("status", true);
    		responseBody.put("message", "Student was deleted successfully.");
    		
    		return ResponseEntity.ok()
        			.header("Content-Type", "application/json")
        			.body(responseBody);
    		
    	} catch (IllegalStateException e) {
    		responseBody.put("status", false);
    		responseBody.put("message", "There was a problem deleting the Student.");
    		
    		return ResponseEntity.badRequest()
        			.header("Content-Type", "application/json")
        			.body(responseBody);
    	}
    }

}