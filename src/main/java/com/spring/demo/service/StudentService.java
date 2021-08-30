package com.spring.demo.service;

//import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.demo.student.Student;
import com.spring.demo.repo.StudentRepository;

//@Component OR
@Service
public class StudentService {
	
	private final StudentRepository stuRepo;
	
	@Autowired
	public StudentService(StudentRepository stuRepo) {
		this.stuRepo = stuRepo;
	}
	
	public List<Student> getStudent() {
		return stuRepo.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = stuRepo.findByEmail(student.getEmail());
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("Email Taken");
		}
		stuRepo.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists = stuRepo.existsById(studentId);
		
		if(!exists) {
			throw new IllegalStateException("Student with id:" + studentId + " does not exists!!!!");
		}
		stuRepo.deleteById(studentId);
	}
	
	@Transactional
	public void updateStudent(
			Long studentId,
			String name,
			String email
			) {
		Student student = stuRepo.findById(studentId).orElseThrow( ()-> new IllegalStateException(
					"Student with id: " + studentId + " does not exists!!!"
				));
		
		if( name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if (email != null && email.length() > 0 &&
				!Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentOptional = stuRepo.findByEmail(email);
			if(studentOptional.isPresent()) {
				throw new IllegalStateException("Email is already Taken");
			}
			student.setEmail(email);
		}
		
	}
	
}
