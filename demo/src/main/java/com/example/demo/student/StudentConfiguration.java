package com.example.demo.student;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student mariam = new Student("Mariam", "marian@gmail.com", LocalDate.of(2000, 1, 5));
			Student pablo = new Student("Pablo", "pablo@gmail.com", LocalDate.of(1997, 6, 7));
			
			studentRepository.save(mariam);
			studentRepository.save(pablo);
			
		};
	}
}
