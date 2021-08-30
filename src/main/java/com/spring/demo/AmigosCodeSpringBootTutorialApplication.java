package com.spring.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.student.Student;


@SpringBootApplication
public class AmigosCodeSpringBootTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmigosCodeSpringBootTutorialApplication.class, args);
	}

}
