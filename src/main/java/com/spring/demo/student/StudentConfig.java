package com.spring.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.demo.repo.StudentRepository;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandlineRunner(StudentRepository repo) {
		return args -> {
			Student bikas = new Student(
					
					"Bikas",
					"Bikas@gmail.com",
					LocalDate.of(1995, 04, 13)
					
					);
			Student priyanka = new Student(
					
					"Priyanka",
					"Priyanka@gmail.com",
					LocalDate.of(1998, 06, 15)
					
					);
			repo.saveAll(List.of(bikas, priyanka));
		};
	}
}
