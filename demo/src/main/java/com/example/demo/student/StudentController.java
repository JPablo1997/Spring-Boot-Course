package com.example.demo.student;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*public StudentController() {
        this.studentService = new StudentService();
    }*/

    @GetMapping
	public List<Student> index() {
		return this.studentService.getStudents();
	}
    
    @PostMapping
    public void store(@RequestBody Student student) {
    	this.studentService.addNewStudent(student);
    }
    
    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
    	this.studentService.deleteStudent(id);
    }

}